public class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 1000;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void sacar(double quantia) {
        if (quantia > this.saldo) {
            System.out.println("Impossível sacar! Saldo insuficiente para o saque da quantia informada, informe outro valor.");
        } else {
            this.saldo -= quantia;
        }
    }

    public void depositar(double quantia) {
        this.saldo += quantia;
    }
}
