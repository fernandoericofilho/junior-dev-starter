import java.util.Scanner;

public class EXERCICIO26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase ou palavra: ");
        // Usamos nextLine() para ler a linha inteira, incluindo espaços
        String texto = scanner.nextLine();

        // O método .length() retorna a quantidade de caracteres na String
        int tamanho = texto.length();

        System.out.println("O tamanho do texto digitado é: " + tamanho + " caracteres.");

        scanner.close();
    }
}