import java.util.Scanner;

public class EXERCICIO27 {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("IMPRIMENDO SE AS PALAVRAS SÃO IGUAIS");
        System.out.print("Informe uma A 1ª palavra: ");
        String p = l.nextLine();

        System.out.print("Informe uma A 2ª palavra: ");
        String p2 = l.nextLine();

        l.close();

        System.out.printf("As palavras %s iguais.", p.equals(p2) ? "são" : "não são");
    }
}
