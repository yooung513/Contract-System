package ltoss.dma.login.controller;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.Menu;
import ltoss.dma.login.models.Privilege;
import ltoss.dma.login.payload.request.MenuByRoleRequest;
import ltoss.dma.login.payload.request.UpdateMenuRequest;
import ltoss.dma.login.payload.response.MessageResponse;
import ltoss.dma.login.repository.MenuRepository;
import ltoss.dma.login.repository.PrivilegeRepository;
import ltoss.dma.login.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/menu")
public class MenuController {

    private final MenuRepository menuRepository;
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuRepository menuRepository, MenuService menuService) {
        this.menuRepository = menuRepository;
        this.menuService = menuService;
    }

    /**
     * ROLE_AMIN 권한이 있으면 모든 메뉴를 볼 수 있다.
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllMenu() {
        List<Menu> menus = menuService.getAllMenu();
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @PostMapping("/byrole")
    public ResponseEntity<?> getMenuByRole(@RequestBody MenuByRoleRequest menuByRoleRequest) {
        List<Menu> menus = menuService.getMenuByRoles(menuByRoleRequest.getPrivilegeName());
        return new ResponseEntity<>(menus, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        return ResponseEntity.ok(new MessageResponse("메뉴 등록에 성공하였습니다."));
    }

    @PutMapping("/{menuId}")
    public ResponseEntity<?> updateMenu(@RequestBody UpdateMenuRequest updateMenuRequest) {
        if (menuService.upadateMenu(updateMenuRequest)) {
            return new ResponseEntity<>("수정할 대상 메뉴 정보를 찾을 수 없습니다. 목록을 새로 고친 후 재확인하세요.", HttpStatus.BAD_REQUEST);
        }
        return  ResponseEntity.ok(new MessageResponse("메뉴 정보를 수정 완료하였습니다."));
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<?> deleteMenu(@PathVariable("menuId") Integer menuId) {
        menuService.deleteMenu(menuId);
        return ResponseEntity.ok(new MessageResponse("메뉴를 삭제했습니다."));
    }

}
