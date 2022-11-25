package ltoss.dma.login.service;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.PrivilegeMenu;
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
     * @return
     */
    public List<PrivilegeMenu> getAllPrivilegeMenu() {
        return privilegeMenuRepository.findAll();
    }
}
