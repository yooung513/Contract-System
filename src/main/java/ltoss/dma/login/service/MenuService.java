package ltoss.dma.login.service;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.*;
import ltoss.dma.login.payload.request.UpdateMenuRequest;
import ltoss.dma.login.repository.MenuRepository;
import ltoss.dma.login.repository.PrivilegeMenuRepository;
import ltoss.dma.login.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final PrivilegeRepository privilegeRepository;
    private final PrivilegeMenuRepository privilegeMenuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository, PrivilegeRepository privilegeRepository, PrivilegeMenuRepository privilegeMenuRepository) {
        this.menuRepository = menuRepository;
        this.privilegeRepository = privilegeRepository;
        this.privilegeMenuRepository = privilegeMenuRepository;
    }

    /**
     * 권한에 따른 메뉴를 가져온다.
     * 여러 권한을 가지면서 메뉴가 중복되는 경우 메뉴 중복을 배제한다.
     * 또 printOrder 오름차순에 따라 정렬하여 메뉴를 반환한다.
     * @return
     */
    public List<Menu> getMenuByRoles(ArrayList<ERole> privilegeName) {
        // 권한명으로부터 온전한 권한 객체를 얻는다.
        List<Privilege> privileges = privilegeRepository.findByPrivilegeNameIn(privilegeName);

        // 권한에 해당하는 메뉴를 얻는다.
        List<PrivilegeMenu> privilegeMenus = privilegeMenuRepository.findByPrivilegeIn(privileges);

        // 메뉴 아이디에 해당하는 온전한 메뉴 객체를 얻는다. 권한마다 겹치는 메뉴 중복을 제거한다.
        Set<Integer> menuIds = privilegeMenus.stream().map(privilegeMenu -> privilegeMenu.getMenu().getMenuId())
                .collect(Collectors.toSet());

        return menuRepository.findByIds(menuIds);
    }

    /**
     * 메뉴를 새롭게 등록한다.
     * 이기수 2022.11.24
     * @param menu
     */
    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
    }

    /**
     * 메뉴 정보를 수정한다.
     * 이기수 2022.11.24
     * @param updateMenuRequest
     */
    public boolean upadateMenu(UpdateMenuRequest updateMenuRequest) {
        // 있는 메뉴 정보인지 확인
        Optional<Menu> menu = menuRepository.findById(updateMenuRequest.getMenuId());
        if (menu.isEmpty()){
            return true;
        }

        // 메뉴 정보 수정
        menuRepository.updateMenu(
                updateMenuRequest.getMenuId(),
                updateMenuRequest.getMenuName(),
                updateMenuRequest.getMenuLink(),
                updateMenuRequest.getPrintOrder()
        );

        return false;
    }

    /**
     * menu_id(PK)에 해당하는 메뉴 데이터를 삭제한다.
     * @param menuId
     */
    public void deleteMenu(Integer menuId) {
        menuRepository.deleteById(menuId);
    }

    /**
     * 전체 메뉴를 가져온다.
     * @return
     */
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }
}
