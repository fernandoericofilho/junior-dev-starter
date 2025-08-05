package lacosDeRepeticao;

public class exerc17 {

    public static void main(String[] args) {

        //Imprima os números pares entre 0 e 50 com while.

        int n = 0;

        while (n <= 50) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
            n++;
        }
    }
}
