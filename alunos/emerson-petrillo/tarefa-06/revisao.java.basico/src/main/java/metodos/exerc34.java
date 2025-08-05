package metodos;

public class exerc34 {

    public static void main(String[] args) {

        //Crie um metodo que inverta uma String.

        String textoOriginal = "hello, motherfucker world";

        String textoInvertido = inverterString(textoOriginal);

        System.out.println("Texto original: " + textoOriginal);
        System.out.println("Texto invertido: " + textoInvertido);
    }

    public static String inverterString(String texto) {
        StringBuilder textoInvertido = new StringBuilder();
        for (int i = texto.length() - 1; i >= 0; i--) {
            textoInvertido.append(texto.charAt(i));
        }
        return textoInvertido.toString();
    }
}