package org.locadora.dao;

import org.locadora.modelo.Aluguel;
import org.locadora.repository.AluguelRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class AluguelDAO implements AluguelRepository {

    private EntityManager entityManager;

    public AluguelDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("locacao-imoveis");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void fechar() {
        entityManager.close();
    }

    @Override
    public void salvarAluguel(Aluguel aluguel) {
        entityManager.getTransaction().begin();
        entityManager.persist(aluguel);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Aluguel> listarAlugueisPagos() {
        return  entityManager.createQuery("select a from Aluguel a where a.dataPagamento != null ")
                .getResultList();
    }

    @Override
    public List<Aluguel> listarAlugueisPagosComAtraso() {
        return entityManager.createQuery("select a from Aluguel a where a.dataPagamento > a.dataVencimento")
                .getResultList();
    }

    public List<Aluguel> listarAlugueisEmAtraso() {
        LocalDate hoje = LocalDate.now();
        return entityManager.createQuery("select a from Aluguel a where :hoje > a.dataVencimento " +
                "and a.dataPagamento = null ").setParameter("hoje", hoje).getResultList();
    }
}
