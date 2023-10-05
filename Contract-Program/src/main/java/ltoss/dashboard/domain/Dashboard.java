package ltoss.dma.dashboard.domain;

import lombok.*;
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
@Table(name = "price")
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Dashboard implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Integer price_id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "mat_code", length = 20)
    private String mat_code;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "updown", precision = 10, scale = 2)
    private BigDecimal updown;

    @Column(name = "rate", precision = 10, scale = 2)
    private BigDecimal rate;

    @Column(name = "stock", precision = 10, scale = 2)
    private BigDecimal stock;

    @Column(name = "reg_code", length = 5)
    private String reg_code;

    @Column(name = "register", length = 45)
    private String register;

    @CreatedDate
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime reg_date;

}