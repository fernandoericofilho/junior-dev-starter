import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a temperatura em graus Celsius: ");
        double celsius = scanner.nextDouble();
        double fahreint = (celsius * 1.8) + 32;
        System.out.println(celsius + " graus Celsius equivale a " + fahreint + " graus Fahreint.");
        scanner.close();
    }
}
