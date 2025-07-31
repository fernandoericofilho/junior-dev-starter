public class Pessoa {
    private String nome;
    private int idade;

    public Pessoa() {
        
    }

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }
    
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Valor inválido! A idade deve ser maior ou igual a 0.");
        }
        this.idade = idade;
    }

    public void exibirDados() {
        System.out.println(this.nome + " tem " + this.idade + " anos.");
    }
}