package ltoss.dma.login.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    @Column(name = "menu_name", length = 45)
    private String menuName;

    @Column(name = "print_order")
    private Integer printOrder;

    @OneToMany(mappedBy = "menu")
    private Set<PrivilegeMenu> privilegeMenu = new HashSet<>();
}
