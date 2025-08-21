import ClassesEObjetos.Aluno;

public class EXERCICIO38 {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("João", 8.5);
        Aluno aluno2 = new Aluno("Ana", 4.0);

        // Forma ideal: constrói a frase inteira e imprime de uma só vez
        System.out.println("O aluno " + aluno1.getNome() + " foi aprovado? " + (aluno1.foiAprovado() ? "Sim" : "Não"));
        System.out.println("A aluna " + aluno2.getNome() + " foi aprovada? " + (aluno2.foiAprovado() ? "Sim" : "Não"));
    }
}