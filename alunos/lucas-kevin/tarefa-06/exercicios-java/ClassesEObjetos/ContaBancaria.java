package ClassesEObjetos;

public class ContaBancaria {
    private String titular;
    private double saldo; // 'private' significa que só pode ser acessado DENTRO desta classe

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado. Novo saldo: R$" + this.saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Novo saldo: R$" + this.saldo);
        } else {
            System.out.println("Saque não realizado. Valor inválido ou saldo insuficiente.");
        }
    }

    // Um "getter" para permitir que o saldo seja lido de fora, mas não alterado diretamente.
    public double getSaldo() {
        return this.saldo;
    }
}
