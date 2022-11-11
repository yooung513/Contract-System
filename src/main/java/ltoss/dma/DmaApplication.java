package ltoss.dma;

import ltoss.dma.price.config.PriceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication(scanBasePackages = {"ltoss.dma.price.web", "ltoss.dma.news", "ltoss.dma.login", "ltoss.dma.exchangerate"})
@Import({PriceConfig.class})
@EnableJpaAuditing
public class DmaApplication {
	public static void main(String[] args) {
		SpringApplication.run(DmaApplication.class, args);
	}

}
