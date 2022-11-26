package ltoss.dma.login.payload.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UpdateMenuRequest {

    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    @Column(name = "menu_name", length = 45)
    private String menuName;

    @Column(name = "menu_link", length = 100)
    private String menuLink;

    @Column(name = "print_order")
    private Integer printOrder;
}
