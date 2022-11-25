/**
 *  user_privilege controller 등록
 *  이름 : 강성욱
 *  @param : crud
 */

package ltoss.dma.userprivilege.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ltoss.dma.login.models.UserPrivilege;
import ltoss.dma.userprivilege.service.UserPrivilegeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class UserPrivilegeController {

    private final UserPrivilegeService userprivilegeService;

    // Create
    @PostMapping("/userPrivilege/insert")
    public ResponseEntity<HttpStatus> save (@RequestBody UserPrivilege userprivilege) {
        userprivilegeService.insert(userprivilege);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Read
    @GetMapping ("/userPrivilege/find")
    public List<UserPrivilege> findAll(){
        return userprivilegeService.findAll();
    }

    // Update
    @PutMapping("/userPrivilege/insert/update")
    public ResponseEntity<HttpStatus> update(@RequestBody UserPrivilege userprivilege) {
        userprivilegeService.update(userprivilege);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Delete
    @DeleteMapping("/userPrivilege/delete")
    public ResponseEntity<HttpStatus> delete (@RequestBody UserPrivilege userprivilege) {
        userprivilegeService.delete(userprivilege);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
