import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a sua nota: ");
        double nota = scanner.nextDouble();
        if (nota >= 7) {
            System.out.println("Sua nota é " + nota + ". Parabéns! Você está aprovado. :)");
        } else if (nota >= 5) {
            System.out.println("Sua nota é " + nota + ". Boa sorte na recuperação. :)");
        } else {
            System.out.println("Sua nota é " + nota + ". Que pena! Você está reprovado. :(");
        }
        scanner.close();
    }
}
