import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Exercicio47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de nomes: ");
        ArrayList<String> nomes = new ArrayList<>();
        int quantidade = scanner.nextInt();
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o " + (i+1) + "º nome: ");
            nomes.add(scanner.next());
        }
        System.out.println("Nomes informados: " + nomes);
        Collections.sort(nomes);
        System.out.println("Nomes informados em Ordem Alfabética: " + nomes);
        scanner.close();
    }
}
