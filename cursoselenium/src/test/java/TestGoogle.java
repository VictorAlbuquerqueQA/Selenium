import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
    @Test
    public void Teste() {
        //WebDriver driver = new EdgeDriver();
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new GeckoDriverInfo();
        //driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(1200, 765));
        //driver.manage().window().maximize();
        driver.get("http://www.google.com");
        //System.out.println(driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        driver.quit();
    }
}

