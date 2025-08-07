import java.util.Scanner;

public class EXERCICIO11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();

        // A condição para votar no Brasil é ter 16 anos ou mais.
        if (idade >= 16) {
            System.out.println("Com " + idade + " anos, a pessoa já pode votar.");
        } else {
            System.out.println("Com " + idade + " anos, a pessoa ainda não pode votar.");
        }

        scanner.close();
    }
}