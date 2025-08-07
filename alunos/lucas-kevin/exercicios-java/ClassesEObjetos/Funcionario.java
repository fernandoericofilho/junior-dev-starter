package ClassesEObjetos;

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Método que modifica o estado interno do objeto
    public void aplicarAumento(double percentual) {
        if (percentual > 0) {
            double aumento = this.salario * (percentual / 100);
            this.salario += aumento;
        } else {
            System.out.println("Percentual de aumento deve ser positivo.");
        }
    }

    public void exibirDetalhes() {
        System.out.printf("Funcionário: %s, Salário Atual: R$%.2f\n", this.nome, this.salario);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }
}