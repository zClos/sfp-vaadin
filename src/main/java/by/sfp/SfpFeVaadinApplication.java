package by.sfp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Profile({"stage","dev","test_server"})
public class SfpFeVaadinApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SfpFeVaadinApplication.class);
		app.setAdditionalProfiles("dev");
		app.run(args);
	}
}
