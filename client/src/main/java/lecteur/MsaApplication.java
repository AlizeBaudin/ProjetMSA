package lecteur;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@ImportAutoConfiguration({SpringApplication.class})
@EnableFeignClients("lecteur")
@ConditionalOnProperty(name = "spring.cloud.config.server.bootstrap", havingValue = "true", matchIfMissing = true)
public class MsaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsaApplication.class, args);
	}

}
