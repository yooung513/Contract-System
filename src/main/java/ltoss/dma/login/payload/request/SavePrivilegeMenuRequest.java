package ltoss.dma.login.payload.request;

import lombok.Data;
import ltoss.dma.login.models.Menu;
import ltoss.dma.login.models.Privilege;

import javax.validation.constraints.NotBlank;

@Data
public class SavePrivilegeMenuRequest {
    private Privilege privilege;
    private Menu menu;
}
