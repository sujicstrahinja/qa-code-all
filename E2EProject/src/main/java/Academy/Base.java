package Academy;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static WebDriver driver = null;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        String propertiesFilePath = "C:\\Users\\sujic\\IdeaProjects\\E2EProject\\src\\main\\resources\\data.properties";
        FileInputStream file = new FileInputStream(propertiesFilePath);
        properties.load(file);
        String browserName = properties.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if(browserName.equals("ie")) {
            System.setProperty("webdriver.ie.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        return driver;
    }

    public void generateScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\sujic\\IdeaProjects\\E2EProject\\screenshots\\screenshot.png"));
    }

    public void closeAllWindows() {
        driver.quit();
    }
}
