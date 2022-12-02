package org.locadora.service;


import org.junit.jupiter.api.*;
import org.locadora.dao.ImovelDAO;
import org.locadora.modelo.Imovel;

public class ImovelServiceTest {
    private ImovelDAO imovelDAO;

    private ImovelService imovelService;

    private String bairro = "Cohab";
    @BeforeEach
    public void start() {
        imovelDAO = new ImovelDAO();
        imovelService = new ImovelService(imovelDAO);
    }

    @Test
    public void deveRecuperarTodosOsApartamentosDisponiveisNoBairro() {

        Imovel imovel = new Imovel();
        imovel.setTipoImovel("apartamento");
        imovel.setBairro(bairro);
        imovel.setAtivo(false);
        imovelService.salvarImovel(imovel);
        Assertions.assertEquals(1,imovelService.apartamentosDisponiveisPorBairro(bairro).size());
    }

    @Test
    public void deveRecuperarTodosOsImoveisDisponiveis() {
        Imovel imovel1 = new Imovel();
        Imovel imovel2 = new Imovel();
        Imovel imovel3 = new Imovel();
        imovel1.setAtivo(false);
        imovel2.setAtivo(false);
        imovel3.setAtivo(true);
        imovel1.setValorAluguelSugerido(700f);
        imovel2.setValorAluguelSugerido(500f);
        imovel3.setValorAluguelSugerido(1000f);

        imovelService.salvarImovel(imovel1);
        imovelService.salvarImovel(imovel2);
        imovelService.salvarImovel(imovel3);

        Assertions.assertEquals(1,imovelService.imoveisDisponiveisPorPreco(600f).size());
    }

    @AfterEach
    public void end() {
        imovelDAO.fechar();
    }

}
