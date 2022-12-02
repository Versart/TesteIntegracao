package org.locadora.service;

import org.locadora.dao.AluguelDAO;
import org.locadora.modelo.Aluguel;
import org.locadora.modelo.Locacao;

import java.util.List;

public class AluguelService {

    private AluguelDAO aluguelDAO;

    public AluguelService(AluguelDAO aluguelDAO) {
        this.aluguelDAO = aluguelDAO;
    }

    public void salvarAluguel(Aluguel aluguel) {
        aluguelDAO.salvarAluguel(aluguel);
    }

    public List<Aluguel> listarAlugueisPagos() {
        return  aluguelDAO.listarAlugueisPagos();
    }

    public List<Aluguel> listarAlugueisPagosComAtraso() {
        return aluguelDAO.listarAlugueisPagosComAtraso();
    }



}
