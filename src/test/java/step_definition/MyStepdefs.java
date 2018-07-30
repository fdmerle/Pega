package step_definition;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.TestingGround;
import settingsObj.DriverTypes;
import wrappers.Driver;

/**
 * Created by Dima on 7/29/2018.
 */


public class MyStepdefs {
    private Driver driver = new Driver();
    private TestingGround testingGround;

    @Given("^I as a user open navigate to url \"([^\"]*)\" using browser \"([^\"]*)\"$")
    public void iAsAUserOpenNavigateToUrlUsingBrowser(String url, DriverTypes arg1) {
        driver.setWebDriver(arg1);
        driver.getWebDriver().get(url);


    }

    @When("^I enter the name as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheNameAsAndPasswordAs(String arg0, String arg1) {
        testingGround = new TestingGround(driver);
        testingGround.loginToPage(driver, arg0, arg1);
    }

    @And("^I press submit button$")
    public void iPressSubmitButton(){
        testingGround.submitLogin(driver);
    }

    @Then("^I have to see text: \"([^\"]*)\"$")
    public void iHaveToSeeText(String arg0) {

        Assert.assertTrue(testingGround.loginSuccessfull(driver, arg0));
    }
@After
    public void clean(){

    driver.getWebDriver().close();
}

}
