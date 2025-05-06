import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
    @Test
    public void AlertSimples(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        driver.findElement(By.id("Alert")).click();
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        Assert.assertEquals("Alert Simples", texto);
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }

    @Test
    public void AlertConfirmCancel(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        //ACCEPT
        driver.findElement(By.id("Confirm")).click();
        Alert alerta = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.accept();
        Assert.assertEquals("Confirmado", alerta.getText());
        alerta.accept();
        //DISMISS
        driver.findElement(By.id("Confirm")).click();
        Assert.assertEquals("Confirm Simples", alerta.getText());
        alerta.dismiss();
        Assert.assertEquals("Negado", alerta.getText());
        alerta.dismiss();
    }
}
