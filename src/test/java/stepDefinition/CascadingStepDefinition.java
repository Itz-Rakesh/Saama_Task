package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Cascading;

public class CascadingStepDefinition extends Cascading {

    Cascading Cas = new Cascading();

    @Given("I open the Web page on {string}")
    public void GotoDemoPage(String Browser)
    {
        Cas.launchApp(Browser);
    }

    @When("I Select State {string}")
    public void I_SelectState(String State) throws InterruptedException {
        Cas.SelectState(State);
    }

    @Then("I should Select {string} for {string}")
    public void I_SelectCity(String City,String State) throws InterruptedException {
        Cas.SelectCity(State,City);
    }

    public void tearDown() {
        super.tearDown();  // Quit the driver
    }
}
