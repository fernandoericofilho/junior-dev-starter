public class Exercicio03 {
    public static void main(String args[]) {
        int a = 10;
        int b = 20;
        System.out.println("Inicialmente A possui o valor " + a + " e B possui o valor " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Agora A possui o valor " + a + " e B possui o valor " + b);
    }
}