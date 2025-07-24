import java.util.Scanner;

public class EXERCICIO28 {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);

        System.out.println("SUBSTITUINDO JAVA POR KOTLIN");
        System.out.print("Informe uma frase que com palavras java: ");
        String f = l.nextLine();

        String sf = f.replace("Java", "Kotlin");

        l.close();
        
        System.out.println("Frase modificada: ");
        System.out.print(sf);
    }
}
