package ClassesEObjetos;

public class Aluno {
    // Atributos privados para proteger os dados
    private String nome;
    private double nota;

    // Construtor
    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    // Método que já existia
    public boolean foiAprovado() {
        return this.nota >= 7.0;
    }

    // --- MÉTODOS GETTERS ---
    // Adicione estes métodos se eles não estiverem lá
    public String getNome() {
        return this.nome;
    }

    public double getNota() {
        return this.nota;
    }
}