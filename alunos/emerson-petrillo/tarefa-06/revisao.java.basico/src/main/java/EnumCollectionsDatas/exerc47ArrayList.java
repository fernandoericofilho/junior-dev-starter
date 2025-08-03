package EnumCollectionsDatas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class exerc47ArrayList {

    //Crie uma lista (ArrayList) de nomes e ordene-a.

    private List<String> nomes;

    public exerc47ArrayList() {
        this.nomes = new ArrayList<>();
    }

    public void adicionarNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nomes.add(nome);
        }
    }

    public void ordenarNomes() {
        Collections.sort(this.nomes);
    }

    public void exibirNomes() {
        System.out.println("--- Lista de Nomes ---");
        if (nomes.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            for (String nome : this.nomes) {
                System.out.println("- " + nome);
            }
        }
        System.out.println();
    }
}
