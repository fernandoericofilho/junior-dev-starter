package ClassesEObjetos;

public class Pessoa {
    // 1. Atributos agora são privados
    private String nome;
    private int idade;

    // Construtor continua o mesmo
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Método de exibição continua útil
    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
    }

    // --- MÉTODOS GETTERS ---
    // Métodos públicos para LER os atributos privados
    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    // --- MÉTODOS SETTERS ---
    // Métodos públicos para MODIFICAR os atributos privados
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        // 4. Adicionando validação no setter da idade
        if (idade >= 0) {
            this.idade = idade;
        } else {
            System.out.println("Erro: A idade não pode ser negativa!");
        }
    }
}