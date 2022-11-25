package ltoss.dma.coop.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Data
@EntityListeners(AuditingEntityListener.class)
public class Coop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coop_id")
    private Integer coop_id;

//    @Column(name = "mat_code")
//    private String mat_code;

    @Column(name = "coop_name" , length = 45)
    private String coop_name;

    @Column(name = "coop_address" , length = 200)
    private String coop_address;

    @Column(name = "coop_tel", length = 15)
    private String coop_tel;

    @Column(name = "coop_fax", length = 15)
    private String coop_fax;

    @Column(name = "res_name", length = 45)
    private String res_name;

    @Column(name = "res_position", length = 10)
    private String res_position;

    @Column(name = "res_dept", length = 10)
    private String res_dept;

    @Column(name = "res_mail",length = 45)
    private String res_mail;

    @Column(name = "remark", length = 512)
    private String remark;
}