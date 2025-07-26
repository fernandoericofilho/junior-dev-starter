public class EXERCICIO39 {
    public class ContaBancaria {
        private String titular;
        private double saldo;

        public ContaBancaria(){}

        public ContaBancaria(String titular, double saldo) {
            this.titular = titular;
            this.saldo = saldo;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.printf("Depósito de R$ %d realizado. Novo saldo: R$ %d.", valor, saldo);
            } else {
                System.out.println("Valor de depósito inválido!");
            }
        }

        public void sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.printf("Saque de R$ %d realizado. Novo saldo: R$ %d.", valor, saldo);
            } else {
                System.out.println("Saldo insuficiente ou valor inválido!");
            }
        }

        public String getTitular() {
            return titular;
        }

        public double getSaldo() {
            return saldo;
        }
    }
}
