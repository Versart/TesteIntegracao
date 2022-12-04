package org.locadora.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.locadora.dao.AluguelDAO;
import org.locadora.modelo.Aluguel;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

public class EmailServiceTest {

    private AluguelDAO aluguelDAO;

    private EmailService emailService;

    private AluguelService aluguelService;

    @BeforeEach
    public void start() {
        aluguelDAO = new AluguelDAO();
        emailService = new EmailService(aluguelDAO);
    }

    @Test
    public void deveEnviarEmailAosClientesComAluguelAtrasado() {
        EmailService emailService1 = Mockito.mock(EmailService.class);
        Mockito.when(emailService1.enviarEmailParaOsClientesComAlugueisAtrasados()).thenReturn(List.of());
    }





    @AfterEach
    public void end(){
        aluguelDAO.fechar();
    }
}
