package ltoss.dma.contract.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import ltoss.dma.coop.domain.Coop;
import ltoss.dma.login.models.User;
import ltoss.dma.price.domain.Price;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateContract {
    @NotBlank
    private Integer cont_id;

    @NotBlank
    private String cont_code;

    @NotBlank
    private BigDecimal cont_price;

    @NotBlank
    private BigDecimal cont_quantity;

    @NotBlank
    private LocalDate cont_date;

    @NotBlank
    private LocalDate cont_enddate;

    @NotBlank
    private String cont_status;

    @NotBlank
    private String mat_code;

    @NotBlank
    private String remark;

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
