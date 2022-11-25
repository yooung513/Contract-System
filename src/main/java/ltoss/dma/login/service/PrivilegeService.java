package ltoss.dma.login.service;

import lombok.extern.slf4j.Slf4j;
import ltoss.dma.login.models.Privilege;
import ltoss.dma.login.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class PrivilegeService {

    private final PrivilegeRepository privilegeRepository;

    @Autowired
    public PrivilegeService(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    /**
     * 모든 권한 목록을 가져온다.
     * 이기수 2022.11.25
     * @return
     */
    public List<Privilege> getAllPrivileges() {
        return privilegeRepository.findAll();
    }
}
