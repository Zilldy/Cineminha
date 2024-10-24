package zilldy.com.github.cineminhav2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zilldy.com.github.cineminhav2.service.ConsumoAPI;

@SpringBootApplication
public class Cineminhav2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Cineminhav2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumoAPI();
		var json = api.obterDados("https://www.omdbapi.com/?t=gilmore+girls$Season1&apikey=570fbd0f");

	}
}
