public class Exercicio05 {
    public static void main(String[] args) {
        final double pi = 3.14;
        pi = 3.1415;
        /*
        error: cannot assign a value to final variable pi.
        Este erro na compilação se dá porque pi foi declarada como uma constante e após atribuído um valor a uma constante, não é possível alterá-lo. 
        */
    }
}
