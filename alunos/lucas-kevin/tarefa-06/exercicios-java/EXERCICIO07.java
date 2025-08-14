public class EXERCICIO07 {
    public static void main(String[] args) {
        int dividendo = 10;
        int divisor = 3;

        // O operador % (módulo) calcula o resto da divisão inteira
        int resto = dividendo % divisor;

        // 10 dividido por 3 é 3, e o resto é 1.
        System.out.println("O resto da divisão de " + dividendo + " por " + divisor + " é: " + resto);

        int dividendo2 = 20;
        int divisor2 = 5;
        int resto2 = dividendo2 % divisor2;

        // 20 dividido por 5 é 4, e o resto é 0.
        System.out.println("O resto da divisão de " + dividendo2 + " por " + divisor2 + " é: " + resto2);
    }
}