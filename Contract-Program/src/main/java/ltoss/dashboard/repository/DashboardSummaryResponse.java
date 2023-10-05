package ltoss.dma.dashboard.repository;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public interface DashboardSummaryResponse {
    @NotBlank
    String getSortation();
    @NotBlank
    BigDecimal getWeek();
    @NotBlank
    BigDecimal getMonth();
    @NotBlank
    BigDecimal getQuarter();
}
