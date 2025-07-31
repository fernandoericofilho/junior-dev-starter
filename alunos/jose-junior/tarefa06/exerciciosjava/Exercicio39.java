public class Exercicio39 {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria();
        conta1.depositar(100);
        System.out.println("Saldo da conta 1 após o depósito: " + conta1.getSaldo());
        conta1.sacar(800);
        System.out.println("Saldo da conta 1 após o saque: " + conta1.getSaldo());
        conta1.sacar(400);
        System.out.println("Saldo da conta 1 após o saque: " + conta1.getSaldo());
    }
}
