import java.util.Scanner;

public class Exercicio29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String string = scanner.next();
        char[] charArray = string.toCharArray();
        String stringInvertida = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            stringInvertida += charArray[i];
        }
        System.out.print("A string '" + string + "' ao contrário fica '" + stringInvertida + "'");
        scanner.close();
    }
}
