package EncapsulamentoEConstrutores;

public class Pessoa {

    //exerc41 e 44
    //Implemente encapsulamento na classe Pessoa (getters e setters).
    //Adicione validação no setter da idade (não permitir valores negativos).

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.setIdade(idade);
    }

    public void exibirDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade + " anos");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            System.out.println("Idade não pode ser negativa. Valor ignorado.");
            return;
        }
        this.idade = idade;
    }
}