package ltoss.dma.contract.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

// @NoArgsConstructor
@Entity
@Getter
@Data
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cont_id")
    private Integer cont_id;

    @Column(name = "cont_code", length = 20)
    private String cont_code;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "coop_id")
    private Integer coop_id;

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

    @ColumnDefault(value= "'N'")           // 입력 무조건해야함 ㅜㅜ
    @Column(name = "alarmflag", length = 3)
    private String alarmflag;

    @Column(name = "remark", length = 512)
    private String remark;

    @Column(name = "editor")
    private Integer editor;

    @CreatedDate
    @Column(name = "editdate", updatable = true)
    private LocalDateTime editdate;

    @Column(name= "price_id")
    private Integer price_id;

}
