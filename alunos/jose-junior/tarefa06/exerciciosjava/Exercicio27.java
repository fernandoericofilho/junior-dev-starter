import java.util.Scanner;

public class Exercicio27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a primeira string: ");
        String string1 = scanner.next();
        System.out.print("Digite a segunda string: ");
        String string2 = scanner.next();
        if (string1.equals(string2)) {
            System.out.println("A string '" + string1 + "' é igual a string '" + string2 + "'");
        } else {
            System.out.println("A string '" + string1 + "' não é igual a string '" + string2 + "'");
        }
        scanner.close();
    }
}
