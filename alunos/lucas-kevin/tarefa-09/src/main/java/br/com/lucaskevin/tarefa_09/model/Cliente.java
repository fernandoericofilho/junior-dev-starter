package br.com.lucaskevin.tarefa_09.model;

// --- IMPORTAÇÕES NOVAS ---
import java.util.ArrayList;
import java.util.List;
// --- FIM DAS IMPORTAÇÕES NOVAS ---

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    // --- RELACIONAMENTOS ADICIONADOS ---
    // Relacionamento Um-para-Um com Endereco
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    // Relacionamento Um-para-Muitos com Telefone
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();
    // --- FIM DOS RELACIONAMENTOS ---


    // --- Construtores ---
    public Cliente() {
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // --- GETTERS E SETTERS NOVOS ---
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        // Garante que o endereço saiba quem é o cliente dele
        if (endereco != null) {
            endereco.setCliente(this);
        }
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    // --- FIM DOS GETTERS E SETTERS NOVOS ---

    // --- equals() e hashCode() (sem alterações) ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // --- toString() (sem alterações de propósito) ---
    @Override
    public String toString() {
        // Note que não incluímos o endereço e os telefones aqui
        // para evitar o erro de loop infinito (StackOverflowError)
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}