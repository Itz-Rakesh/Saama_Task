package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.Assert;
import pages.LoginPage;
import utility.BrowserDriver;


public class LoginStepDefinition extends BrowserDriver {

    LoginPage loginPage = new LoginPage();

    @Given("I open the login page on {string}")
    public void i_open_the_login_page(String Browser) {
        Allure.step("I enter valid credentials");
        loginPage.launchApp(Browser);
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() throws InterruptedException {
        Allure.step("I enter valid credentials");
        loginPage.Login("Admin", "admin123");
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Allure.step("I enter valid credentials");
        loginPage.VerifyHomePage();
    }


    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() throws InterruptedException {
        Allure.step("I enter valid credentials");
        loginPage.Login("Invalid", "Invalid");
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        Allure.step("I enter valid credentials");
        loginPage.getErrorMessage();
    }

    @When("I enter {string} and {string}")
    public void i_enter_credentials(String username, String password) throws InterruptedException {
        Allure.step("I enter valid credentials");
        loginPage.Login(username, password);
    }

    @Then("I should {string} the login")
    public void i_should_see_the_result(String Expresult) {
        Allure.step("I enter valid credentials");
        if (Expresult.equals("successfully")) {
            loginPage.VerifyHomePage();
        } else if (Expresult.equals("see an error message")) {
            loginPage.getErrorMessage();
        }
    }

    @After
    public void tearDown() {
        driver.quit(); // Close the browser
    }
}
