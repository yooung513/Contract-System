package ltoss.dma.contract.payload;

import lombok.Getter;
import lombok.Setter;

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

    @NotBlank
    private Long user_id;

    @NotBlank
    private Integer coop_id;

    @NotBlank
    private Integer price_id;

}
