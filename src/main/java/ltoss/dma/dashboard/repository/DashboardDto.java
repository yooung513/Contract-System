package ltoss.dma.dashboard.repository;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DashboardDto {
    private String sortation;
    private BigDecimal week;

    private BigDecimal month;

    private BigDecimal quarter;

    public DashboardDto(BigDecimal price) {
        this.sortation = "최대값";
        this.week = price.max(price);
    }
}
