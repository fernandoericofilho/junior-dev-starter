package br.com.lucaskevin.tarefa07;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "telefone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @ToString.Exclude // << PONTO CHAVE: Exclui o cliente do toString para quebrar o loop
    private Cliente cliente;
}