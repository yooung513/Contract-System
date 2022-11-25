package ltoss.dma.contract.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Data
@Entity
@Table(name = "contract")
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer cont_id;

    @Column(name = "cont_code", length = 20)
    private String cont_code;

    @Column(name = "cont_price", precision = 10, scale = 2)
    private BigDecimal cont_price;

    @Column(name = "cont_quantity", precision = 10, scale = 2)
    private BigDecimal cont_quantity;

    @Column(name = "cont_date")
    private LocalDate cont_date;

    @Column(name = "cont_enddate")
    private LocalDate cont_enddate;

    @Column(name = "cont_status", length = 5)
    private String cont_status;

    @Column(name = "mat_code", length = 20)
    private String mat_code;

    @Column(name = "alarmprice", precision = 10, scale = 2)
    private BigDecimal alarmprice;

    @Column(name = "alarmflag", length = 3)
    private String alarmflag;

    @Column(name = "remark", length = 512)
    private String remark;

    @Column(name = "editor", length = 20)
    private Long editor;

    @CreatedDate
    @Column(name = "editdate", updatable = false)
    private LocalDateTime editdate;

    @Column(name = "user_id", length = 20)
    private Long user_id;

    @Column(name = "coop_id", length = 10)
    private Integer coop_id;

    @Column(name = "price_id", length = 10)
    private Integer price_id;
}