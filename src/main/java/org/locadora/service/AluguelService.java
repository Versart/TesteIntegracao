package org.locadora.service;

import org.locadora.dao.AluguelDAO;
import org.locadora.modelo.Aluguel;
import org.locadora.modelo.Locacao;

import java.time.temporal.ChronoUnit;
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

    public List<Aluguel> listarAlugueisAtrasados() {
        return aluguelDAO.listarAlugueisEmAtraso();
    }

    public Float pagarAluguel(Float valorPago, Aluguel aluguel) {
        if(valorPago <= 0)
            throw new IllegalArgumentException("Esse valor não paga o aluguel");

        if(aluguel.getDataVencimento().until(aluguel.getDataPagamento(),ChronoUnit.DAYS) > 0){
            long diasAtrasados = aluguel.getDataVencimento().until(aluguel.getDataPagamento(),ChronoUnit.DAYS);
            Float valorComMulta = (0.0033f * aluguel.getValor()) * diasAtrasados;
            if(valorComMulta > (0.80 * aluguel.getValor())) {
                aluguel.setValor(aluguel.getValor() + (0.80f * aluguel.getValor()));
            }
            else{
                aluguel.setValor(aluguel.getValor() + valorComMulta);
            }
        }
        if(valorPago < aluguel.getValor())
            throw new IllegalArgumentException("Esse valor não paga o aluguel");

        return aluguel.getValor();
    }



}
