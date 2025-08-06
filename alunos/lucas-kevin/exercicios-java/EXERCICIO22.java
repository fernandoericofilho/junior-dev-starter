public class EXERCICIO22 {
    public static void main(String[] args) {
        double[] notas = {8.5, 7.0, 9.2, 6.8, 8.0};
        double soma = 0.0;

        // O "for-each" é uma forma mais simples de percorrer todos os elementos de um array
        // "Para cada 'nota' dentro do array 'notas', faça:"
        for (double nota : notas) {
            soma += nota; // Acumula o valor de cada nota na variável 'soma'
        }

        // A média é a soma total dividida pela quantidade de elementos
        double media = soma / notas.length;

        System.out.println("A soma das notas é: " + soma);
        System.out.println("A quantidade de notas é: " + notas.length);
        System.out.println("A média das notas é: " + media);
    }
}