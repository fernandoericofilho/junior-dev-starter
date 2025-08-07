package br.com.lucaskevin.tarefa07;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private String cidade;
    private String estado;
    private String cep;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    @ToString.Exclude // << PONTO CHAVE: Exclui o cliente do toString para quebrar o loop
    private Cliente cliente;
}