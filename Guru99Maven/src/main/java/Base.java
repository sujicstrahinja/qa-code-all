import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

abstract public class Base {
    protected static WebDriver driver = null;

    protected static void initialize(String driverName) {
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
            WebDriver driver = new InternetExplorerDriver();
        }
    }

    protected static void teardown() {
        driver.close();
        driver = null;
    }
}
