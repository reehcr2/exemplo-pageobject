package testes;

import org.junit.jupiter.api.*;

//Usando Page Objects
public class TestAutomacaoWebV2 {
    private PageObjectPreferencias pageObjectPreferencias = new PageObjectPreferencias();

    @BeforeEach
    public void setUp() {
        //Preparaçao
        System.setProperty("webdriver.edge.driver", "/home/renato/drivers/edgedriver_linux64/msedgedriver");
        pageObjectPreferencias.acessaSite();
    }

    @Test
    public void testUsuario1(){
        pageObjectPreferencias.setNames("Jose","Silva");
        pageObjectPreferencias.setGender("masc");
        pageObjectPreferencias.setCar(1);
        pageObjectPreferencias.clicaFinalizar();
        pageObjectPreferencias.verificaAlert();
    }

    @Test
    public void testUsuario2(){
        pageObjectPreferencias.setNames("Gustavo","Carvalho");
        pageObjectPreferencias.setGender("masc");
        pageObjectPreferencias.setCar(0);
        pageObjectPreferencias.clicaFinalizar();
        pageObjectPreferencias.verificaAlert();
    }

    @Test
    public void testUsuario3(){
        pageObjectPreferencias.setNames("Joana","Darc");
        pageObjectPreferencias.setGender("fem");
        pageObjectPreferencias.setCar(2);
        pageObjectPreferencias.clicaFinalizar();
        pageObjectPreferencias.verificaAlert();
    }

    @AfterEach
    public void fecharNavegador(){
        pageObjectPreferencias.fechaNavegador();
    }
}
