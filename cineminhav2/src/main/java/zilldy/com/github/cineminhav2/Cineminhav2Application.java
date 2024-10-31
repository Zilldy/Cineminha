package zilldy.com.github.cineminhav2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zilldy.com.github.cineminhav2.model.DadosEpisodios;
import zilldy.com.github.cineminhav2.model.DadosSerie;
import zilldy.com.github.cineminhav2.service.ConsumoAPI;
import zilldy.com.github.cineminhav2.service.ConverteDados;

@SpringBootApplication
public class Cineminhav2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Cineminhav2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumoAPI();
		var json = api.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=570fbd0f");
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
		json = api.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=570fbd0f");
		DadosEpisodios episodios = conversor.obterDados(json, DadosEpisodios.class);
		System.out.println(episodios);
	}
}
