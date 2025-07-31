import java.util.Scanner;

public class EXERCICIO06 {
    public static void main(String[] args){
        double val1;
        double val2;

        Scanner l = new Scanner(System.in);

        System.out.println("Informe um número: ");
        val1 = l.nextDouble();
        System.out.println("Informe outro número: ");
        val2 = l.nextDouble();

        l.close();

        System.out.println("Soma: " + (val1 + val2));
        System.out.println("Subtração: " + (val1 - val2));
        System.out.println("Multiplicação: " + (val1 * val2));
        System.out.println("Divisão: " + (val1 / val2));

    }
}
