package Academy;

import PageObjects.LandingPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class validateNavigationBar extends Base {

    @BeforeTest
    public void initialize()throws IOException {
        driver = initializeDriver();
    }

    @Test
    public void basePageNavigation() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToPage();
        Assert.assertTrue(landingPage.getNavigationUl().isDisplayed());
    }

    @AfterTest
    public void teardown() {
        driver.close();
        driver = null;
    }
}
