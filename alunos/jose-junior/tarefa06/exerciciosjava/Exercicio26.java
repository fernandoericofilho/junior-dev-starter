import java.util.Scanner;

public class Exercicio26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite algum nome ou palavra: ");
        String texto = scanner.next();
        System.out.println("A string " + texto + " tem " + texto.length() + " caracteres.");
        scanner.close();
    }
}
