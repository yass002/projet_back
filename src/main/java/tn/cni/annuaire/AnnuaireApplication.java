package tn.cni.annuaire;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AnnuaireApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(AnnuaireApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
	
	}

	
}
