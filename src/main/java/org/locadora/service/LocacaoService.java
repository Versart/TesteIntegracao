package org.locadora.service;

import org.locadora.dao.ImovelDAO;
import org.locadora.dao.LocacaoDAO;

public class LocacaoService {

    private LocacaoDAO locacaoDAO;

    public LocacaoService(LocacaoDAO locacaoDAO) {
        this.locacaoDAO = locacaoDAO;
    }
}
