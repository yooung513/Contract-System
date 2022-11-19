package ltoss.dma.login.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_privilege")
public class UserPrivilege {

    @Id
    @Column(name = "user_pri_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userPriId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="privilege_id")
    private Privilege privilege;

    public UserPrivilege(User user, Privilege privilege) {
        this.user = user;
        this.privilege = privilege;
    }
}
