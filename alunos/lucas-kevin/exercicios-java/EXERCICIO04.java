public class EXERCICIO04 {
    public static void main(String[] args) {
        char letra = 'A';

        // Para obter o valor inteiro, basta fazer um "cast"
        int codigoAscii = (int) letra;

        System.out.println("O caractere é: " + letra);
        System.out.println("Seu valor na tabela ASCII é: " + codigoAscii);
    }
}