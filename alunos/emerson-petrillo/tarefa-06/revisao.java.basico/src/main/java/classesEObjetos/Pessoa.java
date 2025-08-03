package classesEObjetos;

public class Pessoa {

    //exerc36
    //Crie uma classe Pessoa com atributos nome e idade, e um metodo para exibir seus dados.

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
    }
}