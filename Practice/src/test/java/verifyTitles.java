import PageObjects.Base;
import PageObjects.Home;
import PageObjects.Register;
import PageObjects.Support;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyTitles extends Base {

    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
    }

    @Test(priority = 0)
    public void verifyRegisterTitle() {
        Register page = new Register(driver);
        page.goToPage();
        String expectedTitle = "Register: Mercury Tours";
        String pageTitle = page.getPageTitle();
        Assert.assertEquals(pageTitle, expectedTitle);
    }

    @Test(priority = 1)
    public void verifySupportTitle() {
        Support page = new Support(driver);
        page.goToPage();
        String expectedTitle = "Under Construction: Mercury Tours";
        String pageTitle = page.getPageTitle();
        Assert.assertEquals(pageTitle, expectedTitle);
    }

    @BeforeMethod
    public void checkHomepage() {
        checkHomepageTitle();
    }

    @AfterTest
    public void closeBrowser() {
        checkHomepageTitle();
        closeBrowser();
    }

    public void checkHomepageTitle() {
        Home page = new Home(driver);
        page.goToPage();
        String expectedTitle = "Welcome: Mercury Tours";
        String pageTitle = page.getPageTitle();
        Assert.assertEquals(pageTitle, expectedTitle);
    }
}
