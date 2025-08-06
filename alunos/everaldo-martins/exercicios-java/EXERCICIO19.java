import java.util.Scanner;
import java.math.BigInteger;

public class EXERCICIO19 {
    public static BigInteger calcularFatorial(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("CALCULADORA DE FATORIAL PRECISO");
        System.out.print("Informe um número não negativo: ");

        int n = l.nextInt();

        if (n < 0) {
            System.out.println("Erro: Número negativo");
        } else {
            System.out.println(n + "! = " + calcularFatorial(n));
        }
         
        l.close();
    }
}