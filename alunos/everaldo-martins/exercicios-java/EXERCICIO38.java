public class EXERCICIO38 {
    public class Aluno {
        private String nome;
        private double nota;

        public Aluno(){}

        public Aluno(String nome, double nota) {
            this.nome = nome;
            this.nota = nota;
        }

        public boolean estaAprovado() {
            return nota >= 7.0;
        }

        public void exibirSituacao() {
            System.out.println(nome + " está " + (estaAprovado() ? "APROVADO" : "REPROVADO"));
        }
      
        public String getNome() {
            return nome;
        }

        public double getNota() {
            return nota;
        }

        public void setNota(double nota) {
            this.nota = nota;
        }
    }
}
