package metodos;

public class exerc32 {

    public static void main(String[] args) {

        //Crie um metodo que receba um número e retorne se ele é primo.

        System.out.println("O número 7 é primo? " + numPrimo(7));

        System.out.println("O número 10 é primo? " + numPrimo(10));

        System.out.println("O número 1 é primo? " + numPrimo(1));
    }

    public static boolean numPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}


