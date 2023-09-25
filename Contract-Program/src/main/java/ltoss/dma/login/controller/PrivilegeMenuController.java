package ltoss.dma.login.controller;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.PrivilegeMenu;
import ltoss.dma.login.payload.request.SavePrivilegeMenuRequest;
import ltoss.dma.login.payload.request.UpdatePrivilegeMenuRequest;
import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.login.service.PrivilegeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/privilegemenu")
public class PrivilegeMenuController {

    private final PrivilegeMenuService privilegeMenuService;

    @Autowired
    public PrivilegeMenuController(PrivilegeMenuService privilegeMenuService) {
        this.privilegeMenuService = privilegeMenuService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPrivilegeMenu() {
        List<PrivilegeMenu> privilegeMenus = privilegeMenuService.getAllPrivilegeMenu();
        return new ResponseEntity<>(privilegeMenus, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePrivilegeMenu(@RequestBody SavePrivilegeMenuRequest save) {
        privilegeMenuService.savePrivilegeMenu(save);
        return ResponseEntity.ok(new MessageResponse("권한별 메뉴 설정을 저장하였습니다."));
    }

    @PutMapping("/{priMenuId}")
    public ResponseEntity<?> updatePrivilegeMenu(@RequestBody UpdatePrivilegeMenuRequest updatePrivilegeMenuRequest) {
        privilegeMenuService.updatePrivilegeMenu(updatePrivilegeMenuRequest);
        return ResponseEntity.ok(new MessageResponse("권한별 메뉴 설정을 수정하였습니다."));
    }

    @DeleteMapping("/{priMenuId}")
    public ResponseEntity<?> deletePrivilegeMenu(@PathVariable("priMenuId") Integer priMenuId) {
        privilegeMenuService.deletePrivilegeMenu(priMenuId);
        return ResponseEntity.ok(new MessageResponse("권한별 메뉴를 삭제하였습니다."));
    }

}
