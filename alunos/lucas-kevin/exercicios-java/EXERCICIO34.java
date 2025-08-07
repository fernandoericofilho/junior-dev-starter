public class EXERCICIO34 {

    // Método que recebe uma String e retorna outra String (a invertida).
    public static String inverterString(String textoOriginal) {
        if (textoOriginal == null) {
            return null;
        }

        StringBuilder textoInvertido = new StringBuilder();
        for (int i = textoOriginal.length() - 1; i >= 0; i--) {
            textoInvertido.append(textoOriginal.charAt(i));
        }
        return textoInvertido.toString();
    }

    public static void main(String[] args) {
        String palavra = "Java";
        String palavraInvertida = inverterString(palavra);

        System.out.println("Original: " + palavra);
        System.out.println("Invertida: " + palavraInvertida); // Esperado: "avaJ"
    }
}