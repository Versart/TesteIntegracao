package org.locadora.dao;

import org.locadora.modelo.Locacao;
import org.locadora.repository.LocacaoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LocacaoDAO implements LocacaoRepository {


    private EntityManager entityManager;

    public LocacaoDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "locacao-imoveis");
        this.entityManager =  entityManagerFactory.createEntityManager();
    }


    @Override
    public void salvarRepository(Locacao locacao) {
        entityManager.getTransaction().begin();
        entityManager.persist(locacao);
        entityManager.getTransaction().commit();
    }

    public void fechar() {
        entityManager.close();
    }
}
