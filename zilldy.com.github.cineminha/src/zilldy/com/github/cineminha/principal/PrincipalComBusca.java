package zilldy.com.github.cineminha.principal;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import zilldy.com.github.cineminha.excecao.ErroDeConversaoDeAnoException;
import zilldy.com.github.cineminha.modelos.Titulo;
import zilldy.com.github.cineminha.modelos.TituloOmdb;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner tc = new Scanner(System.in);
        String busca = "";
        //controller writer
        List<Titulo> titulos = new ArrayList<>();
        // controller api
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.print("Digite o nome do filme para busca: ");
            busca = tc.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            // controller {
            String chave = "570fbd0f";
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + chave;
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //System.out.println(json);


                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                //System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                //System.out.println("Titulo ja convertido");
                //System.out.println(meuTitulo);

                titulos.add(meuTitulo);
                System.out.println("Título adicionado com sucesso!");

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
            // }
        }
        System.out.println(titulos);

        //controller {
        FileWriter escrita = new FileWriter("titulos.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        //}

        tc.close();
    }
}