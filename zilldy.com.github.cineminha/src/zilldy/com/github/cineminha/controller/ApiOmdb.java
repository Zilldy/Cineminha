package zilldy.com.github.cineminha.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import zilldy.com.github.cineminha.modelos.Titulo;
import zilldy.com.github.cineminha.modelos.TituloOmdb;
import zilldy.com.github.cineminha.principal.PrincipalComBusca;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ApiOmdb {

    private String chave = "570fbd0f";
    Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
    List<Titulo> titulos = new ArrayList<>();

    public void buscaApi(String buscaParam) throws IOException, InterruptedException {

        String endereco = "https://www.omdbapi.com/?t=" + buscaParam.replace(" ", "+") + "&apikey=" + chave;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        Titulo meuTitulo = new Titulo(meuTituloOmdb);

        titulos.add(meuTitulo);

        System.out.println("Título adicionado com sucesso!");
    }

    public void escreveJSON() throws IOException {
        FileWriter escrita = new FileWriter("titulos.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
    }

}
