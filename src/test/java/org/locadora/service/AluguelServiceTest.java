package org.locadora.service;

import org.junit.jupiter.api.*;
import org.locadora.dao.AluguelDAO;
import org.locadora.modelo.Aluguel;

import java.time.LocalDate;

public class AluguelServiceTest {

    private AluguelDAO aluguelDAO;

    private AluguelService aluguelService;

    @BeforeEach
    public void start() {
        aluguelDAO = new AluguelDAO();
        aluguelService = new AluguelService(aluguelDAO);
    }

    @Test
    public void deveRecuperarTodosOsAlugueisPagos() {
        Aluguel aluguelPago = new Aluguel();
        Aluguel aluguelNaoPago = new Aluguel();
        aluguelPago.setDataPagamento(LocalDate.of(2022,10,10));

        aluguelService.salvarAluguel(aluguelPago);
        aluguelService.salvarAluguel(aluguelNaoPago);

        Assertions.assertEquals(1,aluguelService.listarAlugueisPagos().size());
    }

    @Test
    public void deveRecuperarTodosOsAlugueisPagosComAtraso() {
        Aluguel aluguelPagoComAtraso = new Aluguel();
        aluguelPagoComAtraso.setDataVencimento(LocalDate.of(2022,12,1));
        aluguelPagoComAtraso.setDataPagamento(LocalDate.of(2022,12,2));

        aluguelService.salvarAluguel(aluguelPagoComAtraso);

        Assertions.assertEquals(1,aluguelService.listarAlugueisPagosComAtraso().size());
    }

    @AfterEach
    public void end() {
        aluguelDAO.fechar();
    }

}
