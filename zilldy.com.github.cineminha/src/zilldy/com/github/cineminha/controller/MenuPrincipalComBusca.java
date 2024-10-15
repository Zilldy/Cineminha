package zilldy.com.github.cineminha.controller;

import zilldy.com.github.cineminha.excecao.ErroDeConversaoDeAnoException;

import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipalComBusca {

    Scanner tc = new Scanner(System.in);
    String buscaParam = "";
    ApiOmdb omdb = new ApiOmdb();

    public void menuPrincipalComBusca() throws IOException {
        while (!buscaParam.equalsIgnoreCase("sair")) {

            System.out.print("Digite o nome do filme para busca: ");
            buscaParam = tc.nextLine();

            if (buscaParam.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                omdb.buscaApi(buscaParam);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (
                    IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (
                    ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        omdb.escreveJSON();

        tc.close();
    }
}
