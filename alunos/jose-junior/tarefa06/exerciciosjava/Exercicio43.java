public class Exercicio43 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double n1 = 4;
        double n2 = 2;
        double soma = calculadora.soma(n1, n2);
        double subtracao = calculadora.subtracao(n1, n2);
        double multiplicacao = calculadora.multiplicacao(n1, n2);
        double divisao = calculadora.divisao(n1, n2);
        System.out.println(n1 + " + " + n2 + " = " + soma);
        System.out.println(n1 + " - " + n2 + " = " + subtracao);
        System.out.println(n1 + " x " + n2 + " = " + multiplicacao);
        System.out.println(n1 + " / " + n2 + " = " + divisao);
    }
}
