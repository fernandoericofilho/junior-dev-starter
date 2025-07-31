public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario() {

    }

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return this.salario;
    }

    private void setSalario(double salario) {
        this.salario = salario;
    }

    public void receberAumento(double aumento) {
        if (aumento <= 0) {
            throw new IllegalArgumentException("Valor inválido! Informe um valor maior do que 0.");
        }
        double novoSalario = this.salario + (aumento * this.salario / 100);
        setSalario(novoSalario);
    }
}
