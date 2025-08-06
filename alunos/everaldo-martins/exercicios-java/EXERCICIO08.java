import java.util.Scanner;

public class EXERCICIO08 {
    public static String parImpar(int n){
        if(n % 2 == 0) {
           return "PAR.";
        }
        return "IMPAR.";
    }

    public static void main(String[] args){
        int numero;

        Scanner l = new Scanner(System.in);

        System.out.println("Informe um número: ");
        numero = l.nextInt();
        l.close();

        System.out.println("O número " + numero + " é " + parImpar(numero));
    }
}
