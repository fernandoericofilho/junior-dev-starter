public class Produto {
    private String nome;
    private double preco;
    private double taxa;

    public Produto() {

    }

    public Produto(String nome, double preco, double taxa) {
        this.nome = nome;
        this.preco = preco;
        this.taxa = taxa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTaxa() {
        return this.taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double calcularPrecoFinal() {
        double imposto = preco * (taxa / 100);
        return imposto + preco;
    }

    public void exibirDetalhesProduto() {
        double precoFinal = calcularPrecoFinal();
        System.out.println(getNome() + " - " + getPreco() + " R$ (Imposto: " + getTaxa() + "%), Total = " + precoFinal + " R$");
    }
}
