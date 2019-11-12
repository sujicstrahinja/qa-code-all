package main;

import main.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        String driverName = "firefox";

        if (driverName.equals("firefox")) {

            System.setProperty("webdriver.gecko.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (driverName.equals("chrome")) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (driverName.equals("opera")) {

            OperaOptions options = new OperaOptions();
            options.setBinary("C:\\Users\\sujic\\AppData\\Local\\Programs\\Opera\\60.0.3255.170\\opera.exe");

            System.setProperty("webdriver.opera.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\operadriver.exe");
            driver = new OperaDriver(options);
        } else if(driverName.equals("edge")) {

            EdgeOptions options = new EdgeOptions();

            System.setProperty("webdriver.edge.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        } else if(driverName.equals("ie")) {

            System.setProperty("webdriver.ie.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
//          ADMIN
//        String username = "mngr230255";
//        String password = "AbUzuhA";

//        CUSTOMER 23924
        String username = "23924";
        String password = "sifra1";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.goToPage();
        loginPage.login(username, password);
    }

    public WebDriver getDriver() {
        return driver;
    }
}