package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginPage extends BrowserDriver
{
    public static String UserName="//input[@name='username']";
    public static String Password="//input[@name='password']";
    public static String LoginButton="//button[@type='submit']";
    public static String ErrorMessage="//div[contains(@role,'alert')]//p";
    public static String Dashboard = "//a[contains(.,'Dashboard')]";

    public void Login(String UN, String PW) throws InterruptedException {
        enterUsername(UN);
        enterPassword(PW);
        clickLoginButton();
    }

    public void enterUsername(String UN) {
        driver.findElement(By.xpath(UserName)).sendKeys(UN);
    }

    public void enterPassword(String PW) {
        driver.findElement(By.xpath(Password)).sendKeys(PW);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath(LoginButton)).click();
    }

    public void getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ErrorMessage)));
        String Error = driver.findElement(By.xpath(ErrorMessage)).getText();
        assertEquals(Error, "Invalid credentials");
    }

    public void VerifyHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard)));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    public void  launchApp(String Browser)
    {
        setUp(Browser);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UserName)));
    }

    public void tearDown() {
        super.tearDown();  // Quit the driver
    }

}
