import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCadastro {
    @Test
    public void TestCadastro(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200, 765));
        driver.get("D:\\Aulas\\Selenium\\campo_treinamento\\componentes.html");
    }
}
