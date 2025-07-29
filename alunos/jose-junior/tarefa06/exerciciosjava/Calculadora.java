public class Calculadora {

    public Calculadora() {
        
    }

    public static double soma(double n1, double n2) {
        return n1 + n2;
    }

    public static double subtracao(double n1, double n2) {
        return n1 - n2;
    }

    public static double multiplicacao(double n1, double n2) {
        return n1 * n2;
    }

    public static double divisao(double n1, double n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Impossível dividir por 0!");
        }
        return n1 / n2;
    }
}
