package org.locadora.dao;

import org.locadora.modelo.Cliente;
import org.locadora.repository.ClienteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteDAO implements ClienteRepository {

    private EntityManager entityManager;

    public ClienteDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "locacao-imoveis");
        this.entityManager =  entityManagerFactory.createEntityManager();
    }


    @Override
    public void salvarCliente(Cliente cliente) {
        entityManager.persist(cliente);
    }
}
