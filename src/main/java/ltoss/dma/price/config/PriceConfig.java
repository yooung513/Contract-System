package ltoss.dma.price.config;

import lombok.RequiredArgsConstructor;
import ltoss.dma.price.repository.JpaPriceRepository;
import ltoss.dma.price.service.PriceService;
import ltoss.dma.price.service.PriceServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class PriceConfig {

    private final EntityManager em;

    @Bean
    public  PriceService priceService() { return new PriceServiceV1(jpaPriceRepository());}

    @Bean
    public JpaPriceRepository jpaPriceRepository() {
        return new JpaPriceRepository(em);
    }
}
