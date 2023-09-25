package ltoss.dma.login.service;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.PrivilegeMenu;
import ltoss.dma.login.payload.request.SavePrivilegeMenuRequest;
import ltoss.dma.login.payload.request.UpdatePrivilegeMenuRequest;
import ltoss.dma.login.repository.PrivilegeMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Transactional
@Service
public class PrivilegeMenuService {

    private final PrivilegeMenuRepository privilegeMenuRepository;

    @Autowired
    public PrivilegeMenuService(PrivilegeMenuRepository privilegeMenuRepository) {
        this.privilegeMenuRepository = privilegeMenuRepository;
    }

    /**
     * 모든 권한별 메뉴 맵핑 정보를 가져온다.
     * 이기수 2022.11.24
     * @return
     */
    public List<PrivilegeMenu> getAllPrivilegeMenu() {
        return privilegeMenuRepository.findAll();
    }

    /**
     * 권한에 따른 메뉴에 대한 설정을 저장한다.
     * 이기수 2022.11.25
     * @param save
     */
    public void savePrivilegeMenu(SavePrivilegeMenuRequest save) {
        PrivilegeMenu privilegeMenu = new PrivilegeMenu();
        privilegeMenu.setPrivilege(save.getPrivilege());
        privilegeMenu.setMenu(save.getMenu());

        privilegeMenuRepository.save(privilegeMenu);
    }

    /**
     * 권한별 메뉴를 하나만 수정한다.
     * 이기수 2022.11.25
     * @param updatePrivilegeMenuRequest
     */
    public void updatePrivilegeMenu(UpdatePrivilegeMenuRequest updatePrivilegeMenuRequest) {
        privilegeMenuRepository.updatePrivilegeMenu(
                    updatePrivilegeMenuRequest.getPriMenuId(),
                    updatePrivilegeMenuRequest.getPrivilege().getPrivilegeId(),
                    updatePrivilegeMenuRequest.getMenu().getMenuId()
                );
    }

    /**
     * 권한별 메뉴 데이터를 하나 삭제한다.
     * 이기수 2022.11.25
     *
     * @param priMenuId
     */
    public void deletePrivilegeMenu(Integer priMenuId) {
        privilegeMenuRepository.deleteById(priMenuId);
    }
}
