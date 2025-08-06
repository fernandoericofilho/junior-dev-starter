package classesEObjetos;

public class Aluno {

    //exerc38
    //Crie uma classe Aluno com nome e nota. Crie um metodo que diga se foi aprovado (nota ≥ 7).

    private String nome;
    private double nota;

    public Aluno(String nome) {
        this.nome = nome;
        this.nota = 0.0; // Aluno inicia sem nota
    }

    public void setNota(double novaNota) {
        if (novaNota >= 0 && novaNota <= 10) {
            this.nota = novaNota;
        } else {
            System.out.println("Erro: A nota informada (" + novaNota + ") é inválida.");
        }
    }

    public boolean foiAprovado() {
        return this.nota >= 7.0;
    }

    public void exibirBoletim() {
        String situacao = this.foiAprovado() ? "Aprovado(a)" : "Reprovado(a)";
        System.out.println("Boletim do Aluno");
        System.out.println("Nome: " + this.nome);
        System.out.println("Nota Final: " + this.nota);
        System.out.println("Situação: " + situacao);
    }
}