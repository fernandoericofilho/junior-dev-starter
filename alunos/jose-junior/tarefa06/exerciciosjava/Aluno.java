public class Aluno {
    private String nome;
    private double nota;

    public Aluno() {

    }

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void verificarNota() {
        if (getNota() >= 7) {
            System.out.println(getNome() + " está aprovado(a)! :)");
        } else {
            System.out.println(getNome() + " está reprovado(a)! :(");
        }
    }
}
