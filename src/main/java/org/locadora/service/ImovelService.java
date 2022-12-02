package org.locadora.service;

import org.locadora.dao.ImovelDAO;
import org.locadora.modelo.Imovel;
import org.locadora.repository.ImovelRepository;

import java.util.List;

public class ImovelService {



    private ImovelDAO imovelDAO;

    public ImovelService(ImovelDAO imovelDAO) {
        this.imovelDAO = imovelDAO;
    }

    public void salvarImovel(Imovel imovel) {
            imovelDAO.salvarImovel(imovel);
    }

    public List<Imovel> apartamentosDisponiveisPorBairro(String bairro) {
        return imovelDAO.apartamentosDisponiveisPorBairro(bairro);
    }

    public List<Imovel> imoveisDisponiveisPorPreco(Float preco) {
        return imovelDAO.imoveisDisponiveisPorPreco(preco);
    }


}
