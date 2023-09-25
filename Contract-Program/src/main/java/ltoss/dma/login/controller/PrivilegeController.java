package ltoss.dma.login.controller;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.Privilege;
import ltoss.dma.login.payload.request.UpdatePrivilegeMenuRequest;
import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.login.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Slf4j
@RequestMapping("/privilege")
public class PrivilegeController {

    private final PrivilegeService privilegeService;

    @Autowired
    public PrivilegeController(PrivilegeService privilegeService) {
        this.privilegeService = privilegeService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPrivileges() {
        List<Privilege> privilegeList = privilegeService.getAllPrivileges();
        return new ResponseEntity<>(privilegeList, HttpStatus.OK);
    }
}
