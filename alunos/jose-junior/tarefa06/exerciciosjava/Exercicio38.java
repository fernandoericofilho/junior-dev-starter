public class Exercicio38 {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Pedro");
        aluno1.setNota(5);
        
        Aluno aluno2 = new Aluno("Ana", 8);

        aluno1.verificarNota();
        aluno2.verificarNota();
    }
}
