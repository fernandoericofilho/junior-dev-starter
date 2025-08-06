import java.util.Scanner;

public class EXERCICIO32 {
    public static boolean verifyPrimo(int a) {
        if (a <= 1) {
            return false;
        }

        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }            
        }

        return true;
    }
    
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);

        System.out.println("Insira um número inteiro: ");

        int n = l.nextInt();

        l.close();

        System.out.printf("O número %d %s", n, verifyPrimo(n) ? "é primo." : "não é primo.");
    }
}