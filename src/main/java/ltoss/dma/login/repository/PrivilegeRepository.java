package ltoss.dma.login.repository;

import ltoss.dma.login.models.ERole;
import ltoss.dma.login.models.Privilege;
import ltoss.dma.login.models.PrivilegeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
    Optional<Privilege> findByPrivilegeName(ERole eRole);

    List<Privilege> findByPrivilegeNameIn(List<ERole> privilegeNames);
}
