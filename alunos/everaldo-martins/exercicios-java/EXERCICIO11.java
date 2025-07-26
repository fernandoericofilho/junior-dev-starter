import java.util.Scanner;

public class EXERCICIO11 {
    public static boolean votante(int idade){
        if (idade >= 16) {
            return true;
        } 
        return false;
    }

    public static void main(String[] args) {
        int idade;
        Scanner l = new Scanner(System.in);
        System.out.println("Digite a idade do eleitor: ");

        idade = l.nextInt();

        l.close();

        System.out.println(votante(idade) ? "É um eleitor." : "Não é um eleitor.");
    }
    
}
