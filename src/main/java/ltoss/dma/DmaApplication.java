package ltoss.dma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan({"dma.src.main.*"})
public class DmaApplication {
	public static void main(String[] args) {
		SpringApplication.run(DmaApplication.class, args);
	}

}
