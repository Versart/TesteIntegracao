package org.locadora.repository;

import org.locadora.modelo.Imovel;

import java.util.List;

public interface ImovelRepository {

    void salvarImovel(Imovel imovel);

    List<Imovel> apartamentosDisponiveisPorBairro(String bairro);

    List<Imovel> imoveisDisponiveisPorPreco(Float preco);
}
