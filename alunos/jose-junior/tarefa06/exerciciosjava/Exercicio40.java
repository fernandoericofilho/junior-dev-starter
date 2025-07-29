public class Exercicio40 {
    public static void main(String[] args) {
        Produto produto1 = new Produto();
        produto1.setNome("Teclado");
        produto1.setPreco(250);
        produto1.setTaxa(10);

        Produto produto2 = new Produto("Mouse", 150, 10);

        produto1.exibirDetalhesProduto();
        produto2.exibirDetalhesProduto();
    }
}
