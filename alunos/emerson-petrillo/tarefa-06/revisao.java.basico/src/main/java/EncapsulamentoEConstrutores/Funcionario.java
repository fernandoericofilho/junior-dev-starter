package EncapsulamentoEConstrutores;

public class Funcionario {

    //exerc45
    //Crie uma classe Funcionario com salário e metodo para aplicar aumento.

    private String nome;
    private double salario;

    public Funcionario(String nome, double salarioInicial) {
        this.nome = nome;
        if (salarioInicial >= 0) {
            this.salario = salarioInicial;
        } else {
            this.salario = 0;
            System.out.println("Aviso: Salário inicial inválido. O salário para " + nome + " foi definido como R$ 0,00.");
        }
    }

    public void aplicarAumento(double percentual) {
        if (percentual > 0) {
            double valorDoAumento = this.salario * (percentual / 100.0);
            this.salario = this.salario + valorDoAumento;
            System.out.println("Aumento de " + percentual + "% aplicado. Novo salário de " + this.nome + ": R$ " + String.format("%.2f", this.salario));
        } else {
            System.out.println("Erro: O percentual de aumento deve ser um valor positivo.");
        }
    }

    public String getNome() {
        return this.nome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void exibirInformacoes() {
        System.out.println("Funcionário: " + this.nome + " | Salário Atual: R$ " + String.format("%.2f", this.salario));
    }
}
