package org.locadora;

import org.locadora.dao.ImovelDAO;
import org.locadora.modelo.Imovel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ImovelDAO imovelDAO = new ImovelDAO();
        String bairro = "Cohab";
        Imovel imovel = new Imovel();
        imovel.setTipoImovel("apartamento");
        imovel.setBairro(bairro);
        imovel.setAtivo(false);
        imovelDAO.salvarImovel(imovel);
        imovelDAO.fechar();

    }
}