import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a sua idade: ");
        int idade = scanner.nextInt();
        if (idade >= 16) {
            System.out.println("Sua idade é " + idade + ", portanto, você pode votar.");
        } else {
            System.out.println("Sua idade é " + idade + ", portanto, você ainda não pode votar.");
        }
        scanner.close();
    }
}
