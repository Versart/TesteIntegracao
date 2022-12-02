package org.locadora.modelo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "tipo_imovel")
    private String tipoImovel;


    private String endereco;

    private String bairro;

    private String cep;

    private Float metragem;

    private Integer dormitorios;

    private Integer banheiros;

    private Integer suites;

    @Column(name = "vagas_garagem")
    private Integer vagasGaragem;

    @Column(name = "valor_aluguel_sugerido")
    private Float valorAluguelSugerido;

    private Boolean ativo;

    private String obs;
    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL)
    private List<Locacao> locacoes;


}
