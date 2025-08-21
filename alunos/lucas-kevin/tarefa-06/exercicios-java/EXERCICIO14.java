import java.util.Scanner;

public class EXERCICIO14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota do aluno (de 0 a 10): ");
        double nota = scanner.nextDouble();

        if (nota >= 7.0) {
            System.out.println("Situação: APROVADO!");
        } else if (nota >= 5.0) { // Não precisa testar se é < 7, pois o primeiro if já falhou
            System.out.println("Situação: RECUPERAÇÃO.");
        } else {
            System.out.println("Situação: REPROVADO.");
        }

        scanner.close();
    }
}