/**
 *  user_privilege controller 등록
 *  이름 : 강성욱
 *  @param : crud
 */

package ltoss.dma.login.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ltoss.dma.login.models.UserPrivilege;
import ltoss.dma.login.payload.request.UpdateUserPrivilegeRequest;
import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.login.service.UserPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/userprivilege")
public class UserPrivilegeController {

    private final UserPrivilegeService userprivilegeService;

    @Autowired
    public UserPrivilegeController(UserPrivilegeService userprivilegeService) {
        this.userprivilegeService = userprivilegeService;
    }

    /**
     * 유저별 권한 데이터를 하나 저장한다.
     * 이기수 2022.11.26
     * @param userprivilege
     * @return
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveUserPrivilege (@RequestBody UserPrivilege userprivilege) {
        userprivilegeService.saveUserPrivilege(userprivilege);
        return ResponseEntity.ok(new MessageResponse("유저별 권한을 저장했습니다."));
    }

    // Read
    @GetMapping ("/all")
    public List<UserPrivilege> findAll(){
        return userprivilegeService.findAll();
    }

    /**
     * userPriId(PK)에 해당하는 유저별 권한 데이터를 수정한다.
     * 이기수 2022.11.26
     * @param updateUserPrivilegeRequest
     * @return ResponseEntity
     */
    @PutMapping("/{userPriId}")
    public ResponseEntity<?> updateUserPrivilege(@RequestBody UpdateUserPrivilegeRequest updateUserPrivilegeRequest) {
        userprivilegeService.updateUserPrivilege(updateUserPrivilegeRequest);
        return ResponseEntity.ok(new MessageResponse("유저별 권한 정보를 수정했습니다."));
    }

    /**
     * userPriId(PK)에 해당하는 유저별 권한 데이터를 하나 지운다.
     * 이기수 2022.11.26
     * @param userPriId
     * @return ResponseEntity
     */
    @DeleteMapping("/{userPriId}")
    public ResponseEntity<?> deleteUserPrivilege (@PathVariable Integer userPriId) {
        userprivilegeService.deleteUserPrivilege(userPriId);
        return ResponseEntity.ok(new MessageResponse("유저별 권한 정보를 삭제 완료하였습니다."));
    }
}
