package org.locadora.service;

import org.locadora.dao.ClienteDAO;
import org.locadora.modelo.Cliente;
import org.locadora.repository.ClienteRepository;

public class ClienteService {

    private ClienteRepository clienteRepository;

    private ClienteDAO clienteDAO;

    public void salvar(Cliente cliente) {
        clienteDAO.salvarCliente(cliente);
    }
}
