import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.Guru99Home;
import pages.Guru99Login;

public class POMTest1 extends BasePage {

    @Test
    public void loginAndVerifyManagerIdHeader() {
        initialize("firefox");
        Guru99Login loginPage = new Guru99Login(driver);
        loginPage.goToPage();
        Assert.assertTrue(loginPage.doesGuru99BankHeaderExist());
        loginPage.loginToGuru99("mngr213366", "jEzArer");

        Guru99Home homePage = new Guru99Home(driver);
        Assert.assertTrue(homePage.doesManagerIdExist());
        loginPage.teardown();
    }
}
