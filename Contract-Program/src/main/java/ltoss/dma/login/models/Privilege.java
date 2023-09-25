package ltoss.dma.login.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer privilegeId;

    @NotBlank
    @Size(max = 20)
    @Column(name = "privilege_name")
    @Enumerated(EnumType.STRING)
    private ERole privilegeName;
}
