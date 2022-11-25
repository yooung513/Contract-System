package ltoss.dma.login.controller;

import ltoss.dma.login.models.PrivilegeMenu;
import ltoss.dma.login.service.PrivilegeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
