package ClassesEObjetos;

// Uma classe "utilitária". Não precisamos criar objetos dela.
public class Calculadora {

    // A palavra 'static' significa que o método pertence à CLASSE, e não a um objeto.
    // Você pode chamá-lo diretamente, sem usar 'new'.
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
            System.out.println("Erro: Divisão por zero.");
            return 0;
        }
        return a / b;
    }
}