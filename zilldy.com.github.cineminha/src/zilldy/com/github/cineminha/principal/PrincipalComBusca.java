package zilldy.com.github.cineminha.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import zilldy.com.github.cineminha.modelos.Titulo;
import zilldy.com.github.cineminha.modelos.TituloOmdb;

public class PrincipalComBusca {
	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner tc = new Scanner(System.in);
		System.out.print("Digite o nome do filme para busca: ");
		var busca = tc.nextLine();

		String chave = "570fbd0f";
		String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + chave;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		String json = response.body();
		System.out.println(json);
		
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		
		TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
		System.out.println(meuTituloOmdb);
		
		try {
			Titulo meuTitulo = new Titulo(meuTituloOmdb);
			System.out.println("Titulo ja convertido");
			System.out.println(meuTitulo);
		} catch (NumberFormatException e) {
			System.out.println("Aconteceu um erro: ");
			System.out.println(e.getMessage());
		}
		System.out.println("O programa finalizou corretamente!");
		
		
		tc.close();
	}
}