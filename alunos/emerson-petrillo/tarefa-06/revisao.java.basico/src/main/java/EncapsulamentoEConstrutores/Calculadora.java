package EncapsulamentoEConstrutores;

public class Calculadora {

    //exerc43
    //Faça uma classe Calculadora com métodos estáticos para soma, subtração etc.

    // Construtor privado para impedir a instanciação da classe.
    private Calculadora() {}

    public static double somar(double a, double b) {
        return a + b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}
