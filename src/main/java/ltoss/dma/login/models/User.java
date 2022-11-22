package ltoss.dma.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ltoss.dma.dept.domain.Dept;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User extends AuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotBlank
    @Size(max = 45)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 256)
    @Column(name = "pw")
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

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "failcnt", insertable = false, columnDefinition = "INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '로그인 실패 횟수'")
    private  Integer failCnt;


    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<UserPrivilege> userPrivilege = new HashSet<>();

    @Column(name = "last_login", insertable = false)
    private LocalDateTime lastLogin;

    public User(String username, String password, String name, String position, String tel, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.position = position;
        this.tel = tel;
        this.email = email;
    }
}
