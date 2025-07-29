import java.util.Scanner;

public class Exercicio34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite alguma string: ");
        String string = scanner.nextLine();
        String stringAoContrario = inverterString(string);
        System.out.println(string + " ao contrário fica " + stringAoContrario);
        scanner.close();
    }

    public static String inverterString(String string) {
        char[] charArray = string.toCharArray();
        String stringInvertida = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            stringInvertida += charArray[i];
        }
        return stringInvertida;
    }
}