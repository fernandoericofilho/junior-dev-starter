package classesEObjetos;

public class ContaBancaria {

    //exerc39
    //Crie uma classe ContaBancaria com métodos para depositar e sacar.

    private String numeroDaConta;
    private String nomeDoTitular;
    private double saldo;

    public ContaBancaria(String numeroDaConta, String nomeDoTitular, double saldoInicial) {
        this.numeroDaConta = numeroDaConta;
        this.nomeDoTitular = nomeDoTitular;

        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
            System.out.println("Aviso: O saldo inicial não pode ser negativo. A conta foi aberta com saldo R$ 0,00.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo = this.saldo + valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Erro: O valor do depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do saque deve ser positivo.");
        } else if (this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Operação falhou: Saldo insuficiente.");
        }
    }

    public void exibirSaldo() {
        System.out.println("Titular: " + this.nomeDoTitular);
        System.out.println("Conta: " + this.numeroDaConta);
        System.out.println("Saldo atual: R$ " + String.format("%.2f", this.saldo));
    }
}