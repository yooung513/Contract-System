package ltoss.dma.login.repository;

import ltoss.dma.login.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    @Query(nativeQuery = true,
    value = "select m.menu_id, m.menu_name, m.menu_link, m.print_order from menu as m where m.menu_id in (:menuIds) order by print_order")
    List<Menu> findByIds(@Param("menuIds") Set<Integer> menuIds);

    @Modifying
    @Query(value = "update menu m" +
            "   set m.menu_name = :menu_name" +
            "     , m.menu_link = :menu_link" +
            "     , m.print_order = :print_order" +
            " where m.menu_id = :menu_id", nativeQuery = true)
    int updateMenu(
            @Param("menu_id") Integer menuId,
            @Param("menu_name") String menuName,
            @Param("menu_link") String menuLink,
            @Param("print_order") Integer printOrder);
}
