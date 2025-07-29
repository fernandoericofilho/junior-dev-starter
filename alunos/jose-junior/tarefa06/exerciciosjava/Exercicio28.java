import java.util.Scanner;

public class Exercicio28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite alguma frase: ");
        String frase = scanner.nextLine();
        frase = frase.replace("Java", "Kotlin");
        System.out.println(frase);
        scanner.close();
    }
}
