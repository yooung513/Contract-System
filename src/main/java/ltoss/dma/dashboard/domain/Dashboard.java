package ltoss.dma.dashboard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import ltoss.dma.contract.domain.Contract;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Table(name = "price")
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Dashboard {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JsonIgnore
    private Integer price_id;

    @Column(name = "mat_code", length = 20)
    private String mat_code;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @JsonIgnore
    private LocalDate date;

    @JsonIgnore
    @Column(name = "updown", precision = 10, scale = 2)
    private BigDecimal updown;

    @JsonIgnore
    @Column(name = "rate", precision = 10, scale = 2)
    private BigDecimal rate;

    @JsonIgnore
    @Column(name = "stock", precision = 10, scale = 2)
    private BigDecimal stock;

    @JsonIgnore
    @Column(name = "reg_code", length = 5)
    private String reg_code;

    @JsonIgnore
    @Column(name = "register", length = 45)
    private String register;

    @JsonIgnore
    @CreatedDate
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime reg_date;

    @JsonIgnore
    @OneToMany(mappedBy = "price", cascade = CascadeType.PERSIST)
    private Set<Contract> contracts = new HashSet<>();
}
