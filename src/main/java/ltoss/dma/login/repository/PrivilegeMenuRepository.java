package ltoss.dma.login.repository;

import ltoss.dma.login.models.ERole;
import ltoss.dma.login.models.Privilege;
import ltoss.dma.login.models.PrivilegeMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrivilegeMenuRepository extends JpaRepository<PrivilegeMenu, Integer> {
    List<PrivilegeMenu> findByPrivilegeIn(List<Privilege> privileges);

    @Modifying
    @Query(value = "update privilege_menu pm" +
            "   set pm.privilege_id = :privilegeId" +
            "     , pm.menu_id = :menuId" +
            " where pm.pri_menu_id = :priMenuId", nativeQuery = true)
    void updatePrivilegeMenu(@Param("priMenuId") Integer priMenuId,
                             @Param("privilegeId") Integer privilegeId,
                             @Param("menuId") Integer menuId);
}