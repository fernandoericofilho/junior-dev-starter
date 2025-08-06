import java.util.Scanner;

public class EXERCICIO29 {
    public static String invertWord(String p){
        char[] array = p.toCharArray();
        int i = 0;
        int f = array.length - 1;

        while (i < f) {
            char aux = array[i];
            array[i] = array[f];
            array[f] = aux;
            i++;
            f--;
        }
        return new String(array); //Convertendo para string.
    }

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);

        System.out.println("INVERTENDO PALAVRAS");
        System.out.print("Informe uma palavra para inverter: ");
        String f = l.nextLine();        

        l.close();
        
        System.out.print("Palavra inicial: ");
        System.out.print(f);

        System.out.print("\nPalavra invertida: ");
        System.out.print(invertWord(f));
    }
}
