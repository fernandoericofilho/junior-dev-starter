import ClassesEObjetos.Produto;

public class EXERCICIO40 {
    public static void main(String[] args) {
        // Criando um produto com taxa de imposto de 10% (0.1)
        Produto notebook = new Produto("Notebook Gamer", 4500.00, 0.10);

        double precoFinal = notebook.calcularPrecoFinal();

        System.out.println("Produto: " + notebook.getNome());
        System.out.println("Preço Base: R$" + notebook.getPrecoBase());
        // Usamos printf para formatar o número com 2 casas decimais
        System.out.printf("Preço Final com Impostos: R$%.2f\n", precoFinal);
    }
}