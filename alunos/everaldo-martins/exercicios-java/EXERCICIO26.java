import java.util.Scanner;

public class EXERCICIO26 {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("IMPRIMENDO TAMANHO DE PALAVRA");
        System.out.print("Informe uma palavra: ");

        String p = l.nextLine();

        l.close();

        System.out.printf("Essa palavra tem %s caracteres.", p.length());
    }
}
