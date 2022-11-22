package ltoss.dma.login.controller;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.User;
import ltoss.dma.login.payload.request.UpdateRequest;
import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<User> user = userRepository.findAll();
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{username}")
    @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        userRepository.deleteByUsername(username);
        return ResponseEntity.ok(new MessageResponse(username + " 삭제하였습니다."));
    }

    @PutMapping("/{username}")
    @Transactional
    public ResponseEntity<?> updateUser(@RequestBody UpdateRequest updateRequest) {
        // 있는 인사 정보인지 확인
        Optional<User> user = userRepository.findById(updateRequest.getUserId());
        if (user.isEmpty()){
            return new ResponseEntity<>("수정 대상 유저 정보를 찾을 수 없습니다. 목록을 새로 고친 후 재확인하세요.", HttpStatus.BAD_REQUEST);
        }

        // 인사 정보 수정
        userRepository.updateUser(
                updateRequest.getName(),
                updateRequest.getPosition(),
                updateRequest.getTel(),
                updateRequest.getEmail(),
                updateRequest.getUserId()
        );

        return  ResponseEntity.ok(new MessageResponse("인사 정보를 수정 완료하였습니다."));
    }
}
