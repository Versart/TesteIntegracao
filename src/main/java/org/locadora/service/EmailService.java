package org.locadora.service;

import org.locadora.dao.AluguelDAO;
import org.locadora.modelo.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class EmailService {

    private AluguelDAO aluguelDAO;

    public EmailService(AluguelDAO aluguelDAO) {
        this.aluguelDAO = aluguelDAO;
    }

    public List<String> enviarEmailParaOsClientesComAlugueisAtrasados() {
        List<Aluguel> alugueisAtrasados = aluguelDAO.listarAlugueisEmAtraso();
        List<String> emailsParaNotificarSobreAtraso = new ArrayList<>();
        for(Aluguel aluguel : alugueisAtrasados) {
            emailsParaNotificarSobreAtraso.add(aluguel.getLocacao().getCliente().getEmail());
        }
        return emailsParaNotificarSobreAtraso;
    }



}
