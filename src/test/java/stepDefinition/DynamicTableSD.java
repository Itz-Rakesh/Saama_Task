package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.After;
import pages.DynamicTablePage;
import utility.BrowserDriver;

public class DynamicTableSD extends DynamicTablePage {

    DynamicTablePage DT = new DynamicTablePage();

    @Given("I landed on the WebPage on {string}")
    public void iLandedOnTheWebPage(String Browser) {
        Allure.step("I enter valid credentials");
        DT.launchApp(Browser);
    }

    @When("I Select {string} and {string}")
    public void iSelectAnd(String ColumnName, String ColumnValue) {
        Allure.step("I enter valid credentials");
        DT.SelectRow(ColumnName,ColumnValue);
    }

    @Then("The {string} row for the {string} value should be Selected")
    public void theRowShouldBeSelected(String ColumnName, String ColumnValue) {
        Allure.step("I enter valid credentials");
        DT.VerifySelectedRow(ColumnName,ColumnValue);
    }

    @After
    public void tearDown() {
        driver.quit(); // Close the browser
    }
}
