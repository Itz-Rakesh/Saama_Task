package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Cascading extends BrowserDriver {
    public static String StateDd="//div[@id='stateCity-wrapper']//div[contains(@class,'placeholder')][contains(.,'Select State')]";
    public static String CityDd="//div[@id='stateCity-wrapper']//div[contains(@class,'placeholder')][contains(.,'Select City')]";

    public void launchApp(String Browser)
    {
        setUp(Browser);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StateDd)));
    }

    public void SelectState(String State) throws InterruptedException
    {
        driver.findElement(By.xpath(StateDd)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@class,'option')][contains(.,'"+State+"')]")).click();
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CityDd)));
    }

    public void SelectCity(String State,String City) throws InterruptedException {
        driver.findElement(By.xpath(CityDd)).click();
        Thread.sleep(1000);
        //List<WebElement> stateOptions = driver.findElements(By.xpath("//div[contains(@class,'option')]"));
        List<WebElement> stateOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select-4-option')]"));
        //WebElement stateDropdown = driver.findElement(By.xpath("//div[contains(@class,'singleValue')]"));
        //Select selectState = new Select(stateDropdown);

        boolean state1Present = false;
        boolean state2Present = false;
        boolean state3Present = false;

        // Loop through the options and check if the state exists
        for (WebElement option : stateOptions) {
            if (option.getText().equals("Delhi")) {
                state1Present = true;
                //option.click();
                //break;
            }
            if (option.getText().equals("Gurgaon")) {
                state2Present = true;
                //option.click();
                //break;
            }
            if (option.getText().equals("Noida")) {
                state3Present = true;
                //option.click();
                //break;
            }
        }


        // Click on the dropdown to expand the options
        WebElement stateDropdown = driver.findElement(By.xpath("//div[contains(@class,'option')][contains(.,'"+City+"')]"));
        stateDropdown.click();





//        for (WebElement option : selectState.getOptions()) {
//            if (option.getText().equals("Delhi")) state1Present = true;
//            if (option.getText().equals("Gurgaon")) state2Present = true;
//            if (option.getText().equals("Noida")) state3Present = true;
//        }



        // Optional: You can verify if the state was selected successfully
        if (!state1Present && !state2Present && !state3Present) {
            System.out.println("State not found in the dropdown");
        }

//        // Verify the states are present
//        assertTrue("City 1 is not present", state1Present);
//        assertTrue("City 2 is not present", state2Present);
//        assertTrue("City 2 is not present", state2Present);
    }
}
