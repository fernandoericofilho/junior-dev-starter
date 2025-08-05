import java.util.Scanner;

public class EXERCICIO09 {
    public static void main(String[] args){
        boolean a;
        boolean b;

        Scanner l = new Scanner(System.in);

        System.out.println("Testando operadores bolenanos:");

        System.out.println("Informe true ou false: ");
        a = l.nextBoolean();
        System.out.println("Informe true ou false: ");
        b = l.nextBoolean();

        l.close();

        // Testa os operadores lógicos
        System.out.println("\nResultados das operações:");
        System.out.println("a && b (AND): " + (a && b));
        System.out.println("a || b (OR): " + (a || b));
        System.out.println("!a (NOT a): " + (!a));
        System.out.println("!b (NOT b): " + (!b));
        
        // Combinações mais complexas
        System.out.println("\nCombinações avançadas:");
        System.out.println("!(a && b): " + !(a && b));
        System.out.println("!a || !b: " + (!a || !b));
        System.out.println("a && !b && !a || b: " + ((a && !b) && (!a || b)));
        System.out.println("(a || b) && !(a && b): " + ((a || b) && !(a && b)));        
    }
}
