import java.util.Scanner;

public class EXERCICIO07 {
    public static void main(String[] args){
        int dividendo;
        int divisor;
        int resto;

        Scanner l = new Scanner(System.in);

        System.out.println("Informe um número: ");
        dividendo = l.nextInt();
        System.out.println("Informe outro número: ");
        divisor = l.nextInt();

        resto = dividendo % divisor;

        l.close();

        System.out.println("Resto da divisão: " + resto);

    }
}