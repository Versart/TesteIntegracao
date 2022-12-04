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
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    private Float valor;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    private String obs;


    @ManyToOne(cascade = CascadeType.ALL)
    private Locacao locacao;


}
