package ltoss.dma.login.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import ltoss.dma.dept.domain.Dept;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class UpdateRequest {
    @NotBlank
    private Long userId;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 45)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 10)
    @Column(name = "position")
    private String position;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_code")
    private Dept dept;

    @NotBlank
    @Size(max = 14)
    @Column(name = "tel")
    private  String tel;

    private Set<String> role;
}
