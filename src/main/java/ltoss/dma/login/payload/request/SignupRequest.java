package ltoss.dma.login.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import ltoss.dma.dept.domain.Dept;
import ltoss.dma.login.models.UserPrivilege;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


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