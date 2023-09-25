package ltoss.dma.login.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ltoss.dma.login.models.Privilege;
import ltoss.dma.login.models.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
public class UpdateUserPrivilegeRequest {
    @NotBlank
    private Integer userPriId;
    private User user;
    private Privilege privilege;
}
