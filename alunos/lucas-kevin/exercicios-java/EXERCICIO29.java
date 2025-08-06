import java.util.Scanner;

public class EXERCICIO29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um texto para ser invertido: ");
        String textoOriginal = scanner.nextLine();

        // StringBuilder é uma classe otimizada para manipular strings
        StringBuilder textoInvertido = new StringBuilder();

        // Percorremos a string original DE TRÁS PARA FRENTE
        // Começamos do último caractere (índice .length() - 1) até o primeiro (índice 0)
        for (int i = textoOriginal.length() - 1; i >= 0; i--) {
            // Pegamos o caractere na posição 'i' e o adicionamos ao final do nosso StringBuilder
            textoInvertido.append(textoOriginal.charAt(i));
        }

        System.out.println("Texto Original: " + textoOriginal);
        System.out.println("Texto Invertido: " + textoInvertido.toString());

        scanner.close();
    }
}