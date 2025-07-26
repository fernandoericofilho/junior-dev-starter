import java.util.Scanner;

public class EXERCICIO30 {
    public static boolean checkPalindrome(String t) {
        String tf = t.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        int i = 0;
        int f = tf.length() - 1;
        
        while (i < f) {
            if (tf.charAt(i) != tf.charAt(f)) {
              return false;
            }           
            i++;
            f--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);

        System.out.println("É PALÍNDROMO?");

        System.out.print("Informe a palavra ou frase: ");
        String frase = l.nextLine();

        l.close();

        System.out.println(checkPalindrome(frase) ? "É um palíndromo.": "Não é um palíndromo.");
    }
}
