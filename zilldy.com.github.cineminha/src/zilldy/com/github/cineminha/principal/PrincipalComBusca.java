package zilldy.com.github.cineminha.principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import zilldy.com.github.cineminha.controller.ApiOmdb;
import zilldy.com.github.cineminha.excecao.ErroDeConversaoDeAnoException;
import zilldy.com.github.cineminha.modelos.Titulo;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner tc = new Scanner(System.in);
        String buscaParam = "";
        List<Titulo> titulos = new ArrayList<>();

        while (!buscaParam.equalsIgnoreCase("sair")) {

            System.out.print("Digite o nome do filme para busca: ");
            buscaParam = tc.nextLine();

            if (buscaParam.equalsIgnoreCase("sair")) {
                break;
            }

            try {

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (
                    IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (
                    ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titulos);

        tc.close();
    }
}