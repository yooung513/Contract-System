package ltoss.dma.contract.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import ltoss.dma.coop.domain.Coop;
import ltoss.dma.login.models.User;
import ltoss.dma.price.domain.Price;
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
    @Column(name = "cont_id")
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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    private Price price;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coop_id")
    private Coop coop;
}