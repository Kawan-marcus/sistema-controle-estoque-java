import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> produtos = new ArrayList<>();

    // CREATE
    public void adicionarProduto(String nome, double preco, int quantidade) {

        produtos.add(new Produto(nome, preco, quantidade));

        System.out.println("Produto cadastrado com sucesso!");
    }

    // READ
    public void listarProdutos() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n===== PRODUTOS =====");

        for (int i = 0; i < produtos.size(); i++) {

            System.out.println(i + " - " + produtos.get(i));
        }
    }

    // DELETE
    public void removerProduto(String nome) {

        boolean removido = produtos.removeIf(
                produto -> produto.getNome().equalsIgnoreCase(nome)
        );

        if (removido) {
            System.out.println("Produto removido!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // UPDATE
    public void adicionarEstoque(String nome, int quantidade) {

        produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .forEach(produto -> produto.adicionarQuantidade(quantidade));
    }

    public void removerEstoque(String nome, int quantidade) {

        produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .forEach(produto -> produto.removerQuantidade(quantidade));
    }

    // BUSCAR
    public void buscarProduto(String nome) {

        produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .forEach(System.out::println);
    }

    // VALOR TOTAL
    public void valorTotalEstoque() {

        double total = produtos.stream()
                .mapToDouble(produto ->
                        produto.getPreco() * produto.getQuantidade())
                .sum();

        System.out.println("Valor total do estoque: R$ " + total);
    }
}