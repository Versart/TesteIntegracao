package org.locadora.service;

import org.junit.jupiter.api.*;
import org.locadora.dao.AluguelDAO;
import org.locadora.modelo.Aluguel;
import org.mockito.Mockito;

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

    @Test
    public void naoDevePagarAluguelComValorInferior() {
        AluguelService aluguelService1 = Mockito.mock(AluguelService.class);
        Aluguel aluguelValor200 = new Aluguel();
        aluguelValor200.setValor(200f);
        Mockito.doThrow(new IllegalArgumentException()).when(aluguelService1).pagarAluguel(
                100f, aluguelValor200
        );
    }

    @Test
    public void deveRetornarValorComMulta() {
        AluguelService aluguelService1 = Mockito.mock(AluguelService.class);
        Aluguel aluguelPagoComAtraso = new Aluguel();
        aluguelPagoComAtraso.setValor(200f);
        aluguelPagoComAtraso.setDataVencimento(LocalDate.now());
        aluguelPagoComAtraso.setDataPagamento(aluguelPagoComAtraso.getDataVencimento().plusDays(3));

        Mockito.when(aluguelService1.pagarAluguel(300f, aluguelPagoComAtraso)).thenReturn(201.98f);

    }

    @AfterEach
    public void end() {
        aluguelDAO.fechar();
    }

}
