package testes;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

//Sem Page Object
public class TestAutomacaoWebV1 {
    private WebDriver navegador;

    @BeforeEach
    public void setUp() {
        //Preparaçao
        System.setProperty("webdriver.edge.driver", "/home/renato/drivers/edgedriver_linux64/msedgedriver");
        navegador = new EdgeDriver();
        navegador.get("file:///home/renato/Documentos/exercicio-automacao/automacao.html");
    }

    @Test
    public void testUsuario1(){
        navegador.findElement(By.id("primeiro_nome")).sendKeys("Renato");
        navegador.findElement(By.id("ultimo_nome")).sendKeys("Silva");
        navegador.findElement(By.id("masc")).click();
        WebElement selectElement = navegador.findElement(By.id("cars"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(1);
        navegador.findElement(By.xpath("/html/body/form/input[7]")).click();
        String textoAlert = navegador.switchTo().alert().getText();
        Assertions.assertEquals("Acabou o teste. Faca o robo clicar no botao OK",textoAlert);
        navegador.switchTo().alert().accept();
    }

    @Test
    public void testUsuario2(){
        navegador.findElement(By.id("primeiro_nome")).sendKeys("Gustavo");
        navegador.findElement(By.id("ultimo_nome")).sendKeys("Carvalho");
        navegador.findElement(By.id("masc")).click();
        WebElement selectElement = navegador.findElement(By.id("cars"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(2);
        navegador.findElement(By.xpath("/html/body/form/input[7]")).click();
        String textoAlert = navegador.switchTo().alert().getText();
        Assertions.assertEquals("Acabou o teste. Faca o robo clicar no botao OK",textoAlert);
        navegador.switchTo().alert().accept();
    }

    @Test
    public void testUsuario3(){
        navegador.findElement(By.id("primeiro_nome")).sendKeys("Joana");
        navegador.findElement(By.id("ultimo_nome")).sendKeys("Darc");
        navegador.findElement(By.id("fem")).click();
        WebElement selectElement = navegador.findElement(By.id("cars"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(0);
        navegador.findElement(By.xpath("/html/body/form/input[7]")).click();
        String textoAlert = navegador.switchTo().alert().getText();
        Assertions.assertEquals("Acabou o teste. Faca o robo clicar no botao OK",textoAlert);
        navegador.switchTo().alert().accept();
    }

    @AfterEach
    public void fecharNavegador(){
        navegador.quit();
    }
}
