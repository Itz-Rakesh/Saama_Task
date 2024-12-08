package utility;

import io.cucumber.java.AfterAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class BrowserDriver
{
    //public static WebDriver driver;

    protected WebDriver driver;

    public void setUp(String Browser) {
        if(Objects.equals(Browser, "Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Objects.equals(Browser, "Edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (Objects.equals(Browser, "FireFox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle).close();
            }
            driver.quit();
        }
    }

}
