public class EXERCICIO03 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        System.out.println("Valores antes da troca:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // A lógica da troca usando aritmética
        a = a + b; // a agora vale 15 (5 + 10)
        b = a - b; // b agora vale 5 (15 - 10)
        a = a - b; // a agora vale 10 (15 - 5)

        System.out.println("\nValores depois da troca:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}