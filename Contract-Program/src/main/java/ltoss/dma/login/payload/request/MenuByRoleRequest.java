package ltoss.dma.login.payload.request;

import lombok.Data;
import ltoss.dma.login.models.ERole;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Data
public class MenuByRoleRequest {

    @NotBlank
    private ArrayList<ERole> privilegeName;
}
