import java.util.ArrayList;
import java.util.Collections; // Importa a classe com métodos úteis para coleções

public class EXERCICIO47 {
    public static void main(String[] args) {
        // ArrayList é uma lista dinâmica, que pode crescer e diminuir de tamanho.
        ArrayList<String> nomes = new ArrayList<>();

        // Adicionando elementos à lista
        nomes.add("Carlos");
        nomes.add("Ana");
        nomes.add("Zeca");
        nomes.add("Beatriz");

        System.out.println("Lista Original: " + nomes);

        // O método Collections.sort() ordena a lista em ordem alfabética/numérica.
        Collections.sort(nomes);

        System.out.println("Lista Ordenada: " + nomes);
    }
}