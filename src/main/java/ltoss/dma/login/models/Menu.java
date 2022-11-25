package ltoss.dma.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    @Column(name = "menu_name", length = 45)
    private String menuName;

    @Column(name = "menu_link", length = 100)
    private String menuLink;

    @Column(name = "print_order")
    private Integer printOrder;

    @JsonIgnore
    @OneToMany(mappedBy = "menu", cascade = CascadeType.REMOVE)
    private Set<PrivilegeMenu> privilegeMenu = new HashSet<>();

    public Menu(Integer menuId, String menuName, String menuLink, Integer printOrder) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuLink = menuLink;
        this.printOrder = printOrder;
    }
}
