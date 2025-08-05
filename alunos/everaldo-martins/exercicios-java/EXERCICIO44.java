public class EXERCICIO44 {
    public class Pessoa {
        private String nome;
        private int idade;  

        public Pessoa(){};

        public Pessoa(String nome, int idade){
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            if(name == null || name.trim().isEmpty()){
                throw IllegalArgumentException("O nome não pode ser vazio ou vazio.");
            }
            this.nome = nome;
        }

        public String getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            if(idade < 0 || idade > 130) {
                throw IllegalArgumentException("Erro: A idade deve ser maior que 0 e menor que 130 anos.");
            }
            this.idade = idade;
        }
    }
}