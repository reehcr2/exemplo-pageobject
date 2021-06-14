package testes;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class PageObjectPreferencias {
    private WebDriver navegador;

    public void acessaSite(){
        navegador = new EdgeDriver();
        navegador.get("file:///home/renato/Documentos/exercicio-automacao/automacao.html");
    }

    public void setNames(String primeiroNome, String ultimoNome){
        navegador.findElement(By.id("primeiro_nome")).sendKeys(primeiroNome);
        navegador.findElement(By.id("ultimo_nome")).sendKeys(ultimoNome);
    }

    public void setGender(String gender){
        navegador.findElement(By.id(gender)).click();
    }

    public void setCar(Integer selected ){
        WebElement selectElement = navegador.findElement(By.id("cars"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(selected);
    }

    public void clicaFinalizar(){
        navegador.findElement(By.xpath("/html/body/form/input[7]")).click();
    }

    public void verificaAlert(){
        String textoAlert = navegador.switchTo().alert().getText();
        navegador.switchTo().alert().accept();
        Assertions.assertEquals("Acabou o teste. Faca o robo clicar no botao OK",textoAlert);
    }

    public void fechaNavegador(){
        navegador.quit();
    }

}
