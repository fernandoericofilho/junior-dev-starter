import ClassesEObjetos.ContaBancaria;

public class EXERCICIO39 {
    public static void main(String[] args) {
        ContaBancaria minhaConta = new ContaBancaria("Lucas", 1000.00);

        System.out.println("Saldo inicial: R$" + minhaConta.getSaldo());

        minhaConta.depositar(500.00);
        minhaConta.sacar(200.00);
        minhaConta.sacar(1500.00); // Tentativa de saque maior que o saldo
    }
}