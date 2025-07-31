import java.util.Scanner;

public class EXERCICIO13 {
    public static int maior(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } 
        return c;
    }

    public static void main(String[] args) {
        int a, b, c;

        Scanner l = new Scanner(System.in);
        System.out.println("Digite o primeiro numero: ");
        a = l.nextInt();
        System.out.println("Digite o segundo numero: ");
        b = l.nextInt();
        System.out.println("Digite o terceiro numero: ");
        c = l.nextInt();
        l.close();
        
        System.out.println("O maior numero é: " + maior(a, b, c));
    }
}
