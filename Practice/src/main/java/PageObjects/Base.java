package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

    public static WebDriver driver = null;
    String pageURL;
    String pageTitle;

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\geckodriver.exe");
        driver = new FirefoxDriver();

        return driver;
    }

    public void goToPage() {
        driver.get(pageURL);
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void closeBrowser() {
        driver.quit();
    }
}
