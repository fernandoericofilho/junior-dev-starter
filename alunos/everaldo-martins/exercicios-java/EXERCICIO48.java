import java.util.HashMap;

public class EXERCICIO48 {
    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<String, Integer>();
        
        people.put("João", 25);
        people.put("Maria", 34);
        people.put("Angela", 23);

        for (String i : people.keySet()) {
            System.out.println("Nome: " + i + " Idade: " + people.get(i));
        }
    }
}
