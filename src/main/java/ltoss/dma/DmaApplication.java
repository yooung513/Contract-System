package ltoss.dma;

import ltoss.dma.config.ExchangeRateConfig;
import ltoss.dma.price.config.PriceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication(scanBasePackages = "ltoss.dma.price.web")
@Import({PriceConfig.class, ExchangeRateConfig.class})
@EnableJpaAuditing
public class DmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmaApplication.class, args);
	}

}
