package estruturasCondicionais;

import java.util.Scanner;

public class exerc14 {

    public static void main(String[] args) {

        //Implemente um sistema simples de nota:
        // se nota ≥ 7, aprovado; entre 5 e 7, recuperação; abaixo de 5, reprovado.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota do aluno: ");
        double nota = scanner.nextDouble();

        if (nota >= 7) {
            System.out.println("Aluno aprovado!");
        } else if (nota >= 5) {
            System.out.println("Aluno em recuperação.");
        } else {
            System.out.println("Aluno reprovado.");
        }

        scanner.close();
    }
}
