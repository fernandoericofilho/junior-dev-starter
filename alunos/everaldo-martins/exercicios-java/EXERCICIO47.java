import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EXERCICIO47 {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<String>();

        nomes.add("Pedro");
        nomes.add("Maria");
        nomes.add("José");
        nomes.add("Carlos");
        nomes.add("Edu");
        nomes.add("Carla");

        Collections.sort(nomes); //Ordem alfábetica A-Z
        //nomes.sort(Comparator.reverseOrder()); //Ordem alfábetica Z-A

        for(int i = 0; i < nomes.size(); i++){
            System.out.println(nomes.get(i));
        }

        
    }
}
