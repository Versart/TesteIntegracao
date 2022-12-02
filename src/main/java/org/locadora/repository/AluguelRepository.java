package org.locadora.repository;

import org.locadora.modelo.Aluguel;

import java.util.List;

public interface AluguelRepository {

    void salvarAluguel(Aluguel aluguel);

    List<Aluguel> listarAlugueisPagos();

    List<Aluguel> listarAlugueisPagosComAtraso();
}
