import java.util.HashMap;
import java.util.Scanner;

public class Exercicio48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de pessoas: ");
        int quantidade = scanner.nextInt();
        String[] nomes = new String[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite o nome da " + (i+1) + " pessoa: ");
            nomes[i] = scanner.next();
        }
        Integer[] idades = new Integer[quantidade];
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Digite a idade de " + nomes[i] + ": ");
            idades[i] = scanner.nextInt();
        }
        HashMap<String, Integer> pessoas = new HashMap<>();
        for (int i = 0; i < quantidade; i++) {
            pessoas.put(nomes[i], idades[i]);
        }
        System.out.println(pessoas);
        scanner.close();
    }
}
