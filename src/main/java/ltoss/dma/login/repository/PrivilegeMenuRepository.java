package ltoss.dma.login.repository;

import ltoss.dma.login.models.ERole;
import ltoss.dma.login.models.Privilege;
import ltoss.dma.login.models.PrivilegeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrivilegeMenuRepository extends JpaRepository<PrivilegeMenu, Integer> {
    List<PrivilegeMenu> findByPrivilegeIn(List<Privilege> privileges);
}