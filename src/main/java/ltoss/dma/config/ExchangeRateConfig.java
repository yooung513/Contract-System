package ltoss.dma.config;

import lombok.RequiredArgsConstructor;
import ltoss.dma.repository.ExchangeRateRepository;
import ltoss.dma.service.ExchangeRateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = "ltoss.dma.repository")
public class ExchangeRateConfig {

    private final ExchangeRateRepository exchangeRateRepository;

    @Bean
    public ExchangeRateService exchangeRateService() {
        return new ExchangeRateService(exchangeRateRepository);
    }
}
