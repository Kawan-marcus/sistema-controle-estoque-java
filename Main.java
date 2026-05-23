import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Estoque estoque = new Estoque();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Adicionar estoque");
            System.out.println("5 - Remover estoque");
            System.out.println("6 - Buscar produto");
            System.out.println("7 - Valor total do estoque");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    estoque.adicionarProduto(nome, preco, quantidade);

                    break;

                case 2:

                    estoque.listarProdutos();

                    break;

                case 3:

                    System.out.print("Nome do produto para remover: ");
                    String remover = sc.nextLine();

                    estoque.removerProduto(remover);

                    break;

                case 4:

                    System.out.print("Nome do produto: ");
                    String adicionar = sc.nextLine();

                    System.out.print("Quantidade para adicionar: ");
                    int qtdAdicionar = sc.nextInt();
                    sc.nextLine();

                    estoque.adicionarEstoque(adicionar, qtdAdicionar);

                    break;

                case 5:

                    System.out.print("Nome do produto: ");
                    String retirar = sc.nextLine();

                    System.out.print("Quantidade para remover: ");
                    int qtdRemover = sc.nextInt();
                    sc.nextLine();

                    estoque.removerEstoque(retirar, qtdRemover);

                    break;

                case 6:

                    System.out.print("Digite o nome do produto: ");
                    String busca = sc.nextLine();

                    estoque.buscarProduto(busca);

                    break;

                case 7:

                    estoque.valorTotalEstoque();

                    break;

                case 0:

                    System.out.println("Saindo do sistema...");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}