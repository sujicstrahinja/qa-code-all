import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid {

    private WebDriver driver;
    String baseUrl, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseUrl = "https://www.google.com/";
        nodeURL = "http://192.168.1.3:5555/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.firefox();
//        capability.setBrowserName("firefox");
//        capability.setCapability("marrionette", true);
//        capability.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
    }

    @Test
    public void simpleTest() {
        driver.get(baseUrl);
        Assert.assertEquals("Google", driver.getTitle());
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
