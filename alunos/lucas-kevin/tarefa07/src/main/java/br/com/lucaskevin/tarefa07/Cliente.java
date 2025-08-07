package br.com.lucaskevin.tarefa07;

import jakarta.persistence.*;
import lombok.*; // Importamos o pacote principal do Lombok

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
// Substituímos @Data por anotações específicas
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id") // Define que a igualdade é baseada apenas no ID
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();

    // Sobrescrevemos o toString para controlar o que é impresso
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}