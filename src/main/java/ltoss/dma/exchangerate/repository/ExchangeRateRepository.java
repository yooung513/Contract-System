package ltoss.dma.exchangerate.repository;

import ltoss.dma.exchangerate.domain.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
}