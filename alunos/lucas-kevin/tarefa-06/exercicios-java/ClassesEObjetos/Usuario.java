package ClassesEObjetos;

public class Usuario {
    // Atributo privado e estático. Este valor será COMPARTILHADO por todos os objetos Usuario.
    private static int totalDeUsuarios = 0;

    // Atributos normais (de instância). Cada objeto terá o seu próprio.
    private int id;
    private String nome;

    // O construtor é chamado toda vez que um NOVO usuário é criado com 'new'
    public Usuario(String nome) {
        // 1. Incrementa o contador compartilhado (estático)
        totalDeUsuarios++;

        // 2. Usa o valor do contador como um ID único para este novo usuário
        this.id = totalDeUsuarios;
        this.nome = nome;

        System.out.println("Usuário '" + this.nome + "' criado com ID " + this.id);
    }

    // --- GETTERS ---
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    // Método estático para acessar o atributo estático.
    // Note que chamamos a partir da classe (Usuario.getTotalDeUsuarios())
    public static int getTotalDeUsuarios() {
        return totalDeUsuarios;
    }
}