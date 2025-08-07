import java.util.HashMap;
import java.util.Map; // Importamos a interface Map

public class EXERCICIO48 {
    public static void main(String[] args) {
        // HashMap armazena pares de Chave -> Valor.
        // Neste caso, a chave é uma String (nome) e o valor é um Integer (idade).
        HashMap<String, Integer> mapaDeIdades = new HashMap<>();

        // Adicionando pares ao mapa com o método .put()
        mapaDeIdades.put("Lucas", 25);
        mapaDeIdades.put("Fernanda", 32);
        mapaDeIdades.put("Ricardo", 45);

        // Recuperando um valor a partir da sua chave
        int idadeDoLucas = mapaDeIdades.get("Lucas");
        System.out.println("A idade de Lucas é: " + idadeDoLucas);

        System.out.println("\n--- Lista Completa ---");
        // Percorrendo todos os pares (entradas) do mapa
        for (Map.Entry<String, Integer> entrada : mapaDeIdades.entrySet()) {
            System.out.println("Nome: " + entrada.getKey() + ", Idade: " + entrada.getValue());
        }
    }
}