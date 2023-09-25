package ltoss.dma.dashboard.repository;

import java.math.BigDecimal;

public interface JpaDashboardDto {
    BigDecimal getWeekMaxPrice();
    BigDecimal getWeekMinPrice();
    BigDecimal getWeekAvgPrice();

    BigDecimal getMonthMaxPrice();
    BigDecimal getMonthMinPrice();
    BigDecimal getMonthAvgPrice();

    BigDecimal getQuarterMaxPrice();
    BigDecimal getQuarterMinPrice();
    BigDecimal getQuarterAvgPrice();

}
