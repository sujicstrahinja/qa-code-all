package stepDefinitions;

import Academy.Base;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.Assert;

public class stepDefinitions extends Base {

    private LoginPage loginPage = null;
    private static Logger log = LogManager.getLogger(Base.class.getName());

    @Given("^Initialized the driver with Firefox browser$")
    public void initialized_the_driver_with_firefox_browser() throws Throwable {
        driver = initializeDriver();
    }

    @And("^User is on home page$")
    public void user_is_on_home_page() throws Throwable {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage();
        landingPage.clickLoginLink();
    }

    @When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_something_and_password_something(String username, String password) throws Throwable {
        this.loginPage = new LoginPage(driver);
        loginPage.setEmailAddress(username);
        loginPage.setPassword(password);
    }

    @When("^User enters username (.+) and password (.+)$")
    public void user_enters_username_and_password(String username, String password) throws Throwable {
        this.loginPage = new LoginPage(driver);
        loginPage.setEmailAddress(username);
        loginPage.setPassword(password);
    }

    @And("^User clicks Login button$")
    public void user_clicks_login_button() throws Throwable {
        this.loginPage.doLogIn();
    }

    @Then("^User logs in$")
    public void user_logs_in_and_gets_redirected() throws Throwable {
        Assert.assertFalse(loginPage.doesEmailFieldExist());
    }

    @And("^Browser windows close$")
    public void browser_windows_close() throws Throwable {
        closeAllWindows();
    }
}
