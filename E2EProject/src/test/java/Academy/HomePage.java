package Academy;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import java.io.IOException;

public class HomePage extends Base {

    private static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize()throws IOException {
        driver = initializeDriver();
    }

    @Test(dataProvider = "getLoginData")
    public void navTest(String username, String password, String statusType) throws IOException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage();
        landingPage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmailAddress(username);
        loginPage.setPassword(password);
        loginPage.doLogIn();
        log.info(statusType);
    }

    @DataProvider
    public Object[][] getLoginData() {
        Object[][] loginData = new Object[2][3];

        // 0: email; 1: password; 2: type;
        loginData[0][0] = "nonrestricteduser@gmail.com";
        loginData[0][1] = "sifra1";
        loginData[0][2] = "Non Restricted User";

        loginData[1][0] = "restricteduser@gmail.com";
        loginData[1][1] = "sifra2";
        loginData[1][2] = "Restricted User";

        return loginData;
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }


}
