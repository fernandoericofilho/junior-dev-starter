import java.util.Scanner;

public class EXERCICIO14 {
    public static String arr(double nota){
        if(nota >= 7.0) {
            return "Aprovado.";
        } 
        else if(nota >= 5.0) {
            return "Recuperação.";
        } 
        return "Reprovado.";
    }

    public static void main(String[] args) {
        double nota;

        Scanner l = new Scanner(System.in);
        System.out.print("Digite a nota do aluno: ");
        nota = l.nextDouble();

        l.close();

        System.out.println("Situação do aluno: " + arr(nota));
    }    
}
