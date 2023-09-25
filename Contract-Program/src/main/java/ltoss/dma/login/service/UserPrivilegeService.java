/**
 *  user_privilege service 등록
 *  이름 : 강성욱
 *
 */
package ltoss.dma.login.service;

import lombok.RequiredArgsConstructor;

import ltoss.dma.login.models.UserPrivilege;
import ltoss.dma.login.payload.request.UpdateUserPrivilegeRequest;
import ltoss.dma.login.repository.UserPrivilegeRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserPrivilegeService {
    private final UserPrivilegeRepository userprivilegeRepository;

    // Read
    public List<UserPrivilege> findAll() {
        return userprivilegeRepository.findAll();
    }

    /**
     * userPriId(PK)에 해당하는 유저별 권한 데이터를 하나 지운다.
     * 이기수 2022.11.26
     * @param userPriId
     */
    public void deleteUserPrivilege(Integer userPriId) {
        userprivilegeRepository.deleteById(userPriId);
    }

    /**
     * userPriId(PK)에 해당하는 유저별 권한 데이터를 수정한다.
     * 이기수 2022.11.26
     * @param updateUserPrivilegeRequest
     */
    public void updateUserPrivilege(UpdateUserPrivilegeRequest updateUserPrivilegeRequest) {
        userprivilegeRepository.updateUserPrivilege(
                updateUserPrivilegeRequest.getUserPriId(),
                updateUserPrivilegeRequest.getUser().getUserId(),
                updateUserPrivilegeRequest.getPrivilege().getPrivilegeId()
        );
    }

    /**
     * 유저별 권한 데이터를 하나 저장한다.
     * 이기수 2022.11.26
     * @param userprivilege
     */
    public void saveUserPrivilege(UserPrivilege userprivilege) {
        userprivilegeRepository.save(userprivilege);
    }
}
