package ltoss.dma.exchangerate.repository;

import ltoss.dma.exchangerate.domain.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<List<ExchangeRate>> findByCurDate(LocalDate date);
}