public class EXERCICIO09 {
    public static void main(String[] args) {
        boolean condicaoA = true;
        boolean condicaoB = false;

        System.out.println("Testando operadores lógicos:");
        System.out.println("condicaoA = " + condicaoA);
        System.out.println("condicaoB = " + condicaoB);
        System.out.println("---------------------------------");

        // Operador E (&&): só é verdadeiro se AMBAS as condições forem verdadeiras.
        System.out.println("condicaoA && condicaoB (E): " + (condicaoA && condicaoB)); // Esperado: false

        // Operador OU (||): é verdadeiro se PELO MENOS UMA das condições for verdadeira.
        System.out.println("condicaoA || condicaoB (OU): " + (condicaoA || condicaoB)); // Esperado: true

        // Operador NÃO (!): inverte o valor booleano.
        System.out.println("!condicaoA (NÃO A): " + (!condicaoA)); // Esperado: false
        System.out.println("!condicaoB (NÃO B): " + (!condicaoB)); // Esperado: true
    }
}