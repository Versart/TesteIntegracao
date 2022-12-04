package org.locadora.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "locacao" , cascade = CascadeType.ALL)
    private List<Aluguel> aluguel;

    @Column(name = "valor_aluguel")
    private Float valorAluguel;

    @Column(name = "percentual_multa")
    private Float percentualMulta;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    private Boolean ativo;

    private String obs;
}
