package classesEObjetos;

public class Produto {

    //exerc40
    //Crie uma classe Produto com metodo que calcule o preço final com imposto.

    private String nome;
    private double precoBase;

    public Produto(String nome, double precoBase) {
        this.nome = nome;
        if (precoBase >= 0) {
            this.precoBase = precoBase;
        } else {
            this.precoBase = 0;
            System.out.println("Aviso: O preço base não pode ser negativo. O produto '" + nome + "' foi criado com preço R$ 0,00.");
        }
    }

    public double getPrecoFinal(double taxaDeImposto) {
        if (taxaDeImposto < 0) {
            System.out.println("Aviso: A taxa de imposto não pode ser negativa. O cálculo será feito sem imposto.");
            return this.precoBase;
        }

        double valorDoImposto = this.precoBase * taxaDeImposto;
        return this.precoBase + valorDoImposto;
    }

    public void exibirInfo() {
        System.out.println("Detalhes do Produto");
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço Base: R$ " + String.format("%.2f", this.precoBase));
    }
}