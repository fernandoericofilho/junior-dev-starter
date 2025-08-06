import java.util.Scanner;

public class EXERCICIO12 {
    public static String pnz(int n) {
        if (n == 0) {
            return "zero"; // Pode ser neutro ou nulo, dependendo do contexto.
        } 
        if (n > 0) {
            return "positivo";
        } 
        return "negativo";

    }
    public static void main(String[] args) {
        int numero;
        Scanner l = new Scanner(System.in);
        System.out.print("Digite um número: ");
        numero = l.nextInt();

        l.close();

        System.out.println("O número informado é " + pnz(numero));   
    }    
}
