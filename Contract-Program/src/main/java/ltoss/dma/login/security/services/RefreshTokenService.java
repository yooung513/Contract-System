package ltoss.dma.login.security.services;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ltoss.dma.login.exception.TokenRefreshException;
import ltoss.dma.login.models.RefreshToken;
import ltoss.dma.login.repository.RefreshTokenRepository;
import ltoss.dma.login.repository.UserRepository;

@Transactional
@Service
public class RefreshTokenService {
    @Value("${dma.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    @Autowired
    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    /**
     * refresh token을 아래 경우에 따라 반환한다.
     * 1. refresh token을 DB에서 조회 후 반환: 아직 기간이 유효한 refresh token이 DB에 있는 경우
     * 2. refresh token을 새로 만든 후 반환:
     *  2.1. DB에 refresh token이 있으나 expiry date를 초과한 경우 삭제하고 새로 생성 후 반환
     *  2.2. DB에 없는 경우 새로 생성 후 반환
     * 이기수 2022.11.26
     * @param userId
     * @return
     */
    public RefreshToken createRefreshToken(Long userId) {
        User user = new User();
        user.setUserId(userId);
        Optional<RefreshToken> refreshTokenSavedDb = refreshTokenRepository.findByUser(user);

        // DB에 있을 때
        if(!refreshTokenSavedDb.isEmpty()) {
            // DB에 저장된 refresh token 기간이 유효하지 않을 때 DB 값 삭제하고 새로 생성한 값 반환
            if (refreshTokenSavedDb.get().getExpiryDate().compareTo(Instant.now()) < 0) {
                refreshTokenRepository.delete(refreshTokenSavedDb.get());

                RefreshToken refreshToken = new RefreshToken();
                refreshToken.setUser(userRepository.findById(userId).get());
                refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
                refreshToken.setToken(UUID.randomUUID().toString());

                refreshToken = refreshTokenRepository.save(refreshToken);

                return refreshToken;
            }

            return refreshTokenSavedDb.get();
        }

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(userRepository.findById(userId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);

        return refreshToken;

    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(Long userId) {
        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}