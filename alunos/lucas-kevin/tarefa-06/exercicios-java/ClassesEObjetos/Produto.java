package ClassesEObjetos;

public class Produto {
    // 1. Tornamos os atributos privados
    private String nome;
    private double precoBase;
    private double taxaImposto;

    // Construtor (continua o mesmo)
    public Produto(String nome, double precoBase, double taxaImposto) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.taxaImposto = taxaImposto;
    }

    // Método de cálculo (continua o mesmo)
    public double calcularPrecoFinal() {
        return this.precoBase * (1 + this.taxaImposto);
    }

    // --- MÉTODOS GETTERS ---
    // 2. Adicionamos os métodos públicos para acessar os dados privados
    public String getNome() {
        return this.nome;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }

    public double getTaxaImposto() {
        return this.taxaImposto;
    }
}