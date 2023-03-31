package cz.cvut.fel.groscdan.crmsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"cz.cvut.fel.groscdan.crmsystem.repository", "cz.cvut.fel.groscdan.crmsystem.security.repository"})
public class CrmSystemApplication {


	public static void main(String[] args) {
		SpringApplication.run(CrmSystemApplication.class, args);
	}

}
