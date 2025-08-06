public class EXERCICIO41 {
    public class Funcionario {
        private String nome;
        private double salario;  

        public Funcionario(){};

        public Funcionario(String nome, double salario) {
            this.nome = nome;
            this.salario = salario;
        }

        public void aumentoSalarial(double aumento) {
            if (aumento <= 0) {
                throw new IllegalArgumentException("Não se pode aumentar subtraindo.");
            }
            double novoSalario = this.salario * (aumento / 100);
            this.salario += novoSalario;
        }
    }
}