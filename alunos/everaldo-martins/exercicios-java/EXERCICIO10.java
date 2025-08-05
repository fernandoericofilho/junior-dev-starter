import java.util.Scanner;

public class EXERCICIO10 {
    public static boolean entre10e100(int n){
        if (n > 10 && n < 100) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int n;

        Scanner l = new Scanner(System.in);

        System.out.println("Informe true ou false: ");
        n = l.nextInt();

        l.close();

        System.out.println(entre10e100(n) ? "Está entre 10 e 100." : "Não está entre 10 e 100.");      
    }
}
