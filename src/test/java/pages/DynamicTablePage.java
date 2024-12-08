package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserDriver;

import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class DynamicTablePage extends BrowserDriver {

    public static String CheckBox="//th[contains(.,'SelectCandidate')]";

    public void  launchApp(String Browser)
    {
        setUp(Browser);
        driver.manage().window().maximize();
        driver.get("https://testuserautomation.github.io/WebTable/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CheckBox)));
    }

    public void SelectRow(String ColumnName,String ColumnValue)
    {
        String ColumnID = null;
        if(Objects.equals(ColumnName, "FirstName"))
        {
            ColumnID="2";
        } else if (Objects.equals(ColumnName, "LastName"))
        {
            ColumnID = "3";
        }
        else
        {

        }
        String XP = "//tr[td["+ColumnID+"]='"+ColumnValue+"']/td/input[@type='checkbox']";
        driver.findElement(By.xpath(XP)).click();
    }

    public void VerifySelectedRow(String ColumnName,String ColumnValue){
        int ColumnID = 0;
        if(Objects.equals(ColumnName, "FirstName"))
        {
            ColumnID=1;
        } else if (Objects.equals(ColumnName, "LastName"))
        {
            ColumnID = 2;
        }
        String XP = "//tr[td["+(ColumnID+1)+"]='"+ColumnValue+"']/td[input[@type='checkbox']]/following-sibling::td["+(ColumnID)+"]";
        String SV = driver.findElement(By.xpath(XP)).getText();
        assertEquals(SV, ColumnValue);
    }
}
