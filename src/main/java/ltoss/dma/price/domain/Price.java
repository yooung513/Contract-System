package ltoss.dma.price.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ltoss.dma.contract.domain.Contract;
import ltoss.dma.price.repository.JpaPriceDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@SqlResultSetMapping(//* Dto 에서 조회할 엔티티 항목들 맵핑 작업//
        name = "PriceForGraph",
        classes = {
                @ConstructorResult(
                        targetClass = JpaPriceDto.class,
                        columns = {
                                @ColumnResult(name = "price", type = BigDecimal.class),
                                @ColumnResult(name = "date", type = LocalDate.class),
                                @ColumnResult(name = "matCode", type = String.class)
                        }
                )
        }
)
@NoArgsConstructor
@Getter
@Data
@Entity
@Table(name = "price",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"date","mat_code"})
        })
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Price implements Serializable {

    /**
     * priceid  : Int           > Integer       / 가격 ID          (Key)
     * date     : datetime      > LocalDate     / 가격 일자         (대리 key)
     * matcode  : varchar(20)   > String        / 원자재 코드        (대리 key)
     * price    : decimal       > BigDecimal    / 원자재 가격
     * updown   : decimal       > BigDecimal    / 전일대비 등락
     * rate     : decimal       > BigDecimal    / 전일대비 등락비
     * stock    : decimal       > BigDecimal    / 재고량
     * regcode  : varchar(5)    > String        / 등록코드
     * register : varchar(45)   > String        / 등록자
     * regdate  : datetime      > LocalDate     / 등록 일시
     */

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer price_id;

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

    @JsonIgnore
    @OneToMany(mappedBy = "price", cascade = CascadeType.PERSIST)
    private Set<Contract> contracts = new HashSet<>();
}
