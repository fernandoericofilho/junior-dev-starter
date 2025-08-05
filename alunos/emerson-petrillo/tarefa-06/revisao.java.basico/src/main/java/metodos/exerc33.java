package metodos;

public class exerc33 {

    public static void main(String[] args) {

        //Crie um metodo que calcule o fatorial de um número.

        int numeroTeste = 5;
        long resultado = calcularFatorial(numeroTeste);
        System.out.println("O fatorial de " + numeroTeste + " é: " + resultado);

        int numeroZero = 0;
        long resultadoZero = calcularFatorial(numeroZero);
        System.out.println("O fatorial de " + numeroZero + " é: " + resultadoZero);

        int numeroNegativo = -3;
        long resultadoNegativo = calcularFatorial(numeroNegativo);
        System.out.println("Tentando calcular o fatorial de " + numeroNegativo + ": " + resultadoNegativo);
    }

    public static long calcularFatorial(int numero) {
        if (numero < 0) {
            return -1;
        }
        if (numero == 0) {
            return 1;
        }
        long resultado = 1;
        for (int i = numero; i > 1; i--) {
            resultado = resultado * i;
        }
        return resultado;
    }
}