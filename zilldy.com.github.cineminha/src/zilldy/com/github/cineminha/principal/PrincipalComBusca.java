package zilldy.com.github.cineminha.principal;

import zilldy.com.github.cineminha.controller.MenuPrincipalComBusca;

import java.io.IOException;

public class PrincipalComBusca {
<<<<<<< HEAD
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
=======
    public static void main(String[] args) throws IOException {
        MenuPrincipalComBusca busca = new MenuPrincipalComBusca();

        busca.menuPrincipalComBusca();

>>>>>>> 10f6b085a58a9aa0af9fbbdb81a38a40368a8c5f
    }
}
