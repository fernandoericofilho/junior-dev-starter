public class EXERCICIO43 {
    public class Calculadora {
        public static double soma(double a, double b) {
            return a + b;
        } 
        
        public static double subtracao(double a, double b) {
            return a - b;
        }

        public static double multiplicacao(double a, double b) {
            return a * b;
        }

        public static double dividisao(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero não é permitida!");
            }
            return a / b;
        }
    }
}
