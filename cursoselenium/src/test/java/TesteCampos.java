import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampos {
    @Test
    public void TextField() {
        //WebDriver driver = new EdgeDriver();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new GeckoDriverInfo();
        //driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(1200, 765));
        //driver.manage().window().maximize();
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        //System.out.println(driver.getTitle());
        Assert.assertEquals("Campo de Treinamento", driver.getTitle());
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste do Vittu");
        Assert.assertEquals("Teste do Vittu", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void TextArea() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste do Vittu \npara \nSugestoes");
        Assert.assertEquals("Teste do Vittu \npara \nSugestoes", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void RadioButton() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        Assert.assertFalse(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
        driver.quit();
    }

    @Test
    public void CheckBox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:1")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:3")).isSelected());
        driver.quit();
    }

    @Test
    public void ComboBox() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        //select by Index
        combo.selectByIndex(0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("1o grau incompleto", combo.getFirstSelectedOption().getText());
        combo.selectByIndex(1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("1o grau completo", combo.getFirstSelectedOption().getText());
        combo.selectByIndex(2);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
        combo.selectByIndex(3);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
        combo.selectByIndex(4);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
        combo.selectByIndex(5);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Especializacao", combo.getFirstSelectedOption().getText());
        combo.selectByIndex(6);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
        combo.selectByIndex(7);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Doutorado", combo.getFirstSelectedOption().getText());

        //select by value
        combo.selectByValue("1grauincomp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("1o grau incompleto", combo.getFirstSelectedOption().getText());
        combo.selectByValue("1graucomp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("1o grau completo", combo.getFirstSelectedOption().getText());
        combo.selectByValue("2grauincomp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
        combo.selectByValue("2graucomp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
        combo.selectByValue("superior");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
        combo.selectByValue("especializacao");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Especializacao", combo.getFirstSelectedOption().getText());
        combo.selectByValue("mestrado");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
        combo.selectByValue("doutorado");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Doutorado", combo.getFirstSelectedOption().getText());

        //select by VisibleText
        combo.selectByVisibleText("1o grau incompleto");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("1o grau incompleto", combo.getFirstSelectedOption().getText());
        combo.selectByVisibleText("1o grau completo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("1o grau completo", combo.getFirstSelectedOption().getText());
        combo.selectByVisibleText("2o grau incompleto");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("2o grau incompleto", combo.getFirstSelectedOption().getText());
        combo.selectByVisibleText("2o grau completo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
        combo.selectByVisibleText("Superior");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
        combo.selectByVisibleText("Especializacao");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Especializacao", combo.getFirstSelectedOption().getText());
        combo.selectByVisibleText("Mestrado");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
        combo.selectByVisibleText("Doutorado");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Assert.assertEquals("Doutorado", combo.getFirstSelectedOption().getText());

        //Get Options by Combo and FOR/IF
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());
        boolean encontrou = false;
        for (WebElement option: options){
            if (option.getText().equals("1o grau incompleto")){
                encontrou = true;
                break;
            }
        }
        Assert.assertTrue(encontrou);
        driver.quit();
    }

    @Test
    public void ComboMultiplaEscolha() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByContainsVisibleText("Natacao");
        combo.selectByContainsVisibleText("Corrida");
        combo.selectByContainsVisibleText("O que eh esporte?");
        List<WebElement> AllSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, AllSelectedOptions.size());

        combo.deSelectByContainsVisibleText("Corrida");
        AllSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, AllSelectedOptions.size());
        driver.quit();
    }

    @Test
    public void Botoes() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        driver.findElement(By.id("buttonSimple")).click();

        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
        driver.quit();
    }

    @Test
    public void Links() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        driver.findElement(By.linkText("Voltar")).click();
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
        //driver.quit();
    }

    @Test
    public void BuscarTextos() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
        driver.findElement(By.tagName("body"));
        //System.out.println(driver.findElement(By.tagName("body")).getText());
        //Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
        //driver.quit();
    }
}