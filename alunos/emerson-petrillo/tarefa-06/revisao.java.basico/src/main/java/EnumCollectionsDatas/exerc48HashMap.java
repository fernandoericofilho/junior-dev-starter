package EnumCollectionsDatas;

import java.util.HashMap;
import java.util.Map;

public class exerc48HashMap {

    //Use um HashMap para armazenar nomes e idades.

    private Map<String, Integer> contatos;

    public exerc48HashMap() {
        this.contatos = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer idade) {
        if (nome != null && !nome.trim().isEmpty() && idade != null && idade >= 0) {
            this.contatos.put(nome, idade);
        }
    }

    public Integer buscarIdadePorNome(String nome) {
        return this.contatos.get(nome);
    }

    public void removerContato(String nome) {
        this.contatos.remove(nome);
    }

    public void exibirContatos() {
        System.out.println("--- Agenda de Contatos ---");
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            for (Map.Entry<String, Integer> entry : contatos.entrySet()) {
                System.out.println("- Nome: " + entry.getKey() + " | Idade: " + entry.getValue() + " anos");
            }
        }
        System.out.println();
    }
}

