package org.locadora.dao;

import org.locadora.modelo.Imovel;
import org.locadora.repository.ImovelRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ImovelDAO implements ImovelRepository {


    private EntityManager entityManager;

    public ImovelDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(
                "locacao-imoveis");
        this.entityManager =  entityManagerFactory.createEntityManager();
    }

    @Override
    public void salvarImovel(Imovel imovel) {
        entityManager.getTransaction().begin();
        entityManager.persist(imovel);
        entityManager.getTransaction().commit();
    }

    public void fechar() {
        entityManager.close();
    }

    @Override
    public List<Imovel> apartamentosDisponiveisPorBairro(String bairro) {
       return entityManager.createQuery("select i from Imovel i where i.bairro = :bairro " +
                       "and i.tipoImovel = 'apartamento' and i.ativo = false ")
                .setParameter("bairro",bairro).getResultList();

    }

    @Override
    public List<Imovel> imoveisDisponiveisPorPreco(Float preco) {
        return entityManager.createQuery("select i from Imovel i where i.valorAluguelSugerido <= :preco and " +
                "i.ativo = false ").setParameter("preco", preco).getResultList();
    }
}
