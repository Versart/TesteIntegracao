package org.locadora.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.locadora.dao.ImovelDAO;
import org.locadora.dao.LocacaoDAO;

public class LocacaoServiceTest {

    private LocacaoDAO locacaoDAO;

    private LocacaoService locacaoService;

    @BeforeEach
    public void start() {
        locacaoDAO = new LocacaoDAO();
        locacaoService = new LocacaoService(locacaoDAO);
    }


    @AfterEach
    public void end() {
        locacaoDAO.fechar();
    }
}
