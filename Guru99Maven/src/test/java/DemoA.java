import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoA {

    @Test
    public void run() {
        WebDriver driver = new FirefoxDriver();
        Reporter.log("browser is opened now");
        driver.manage().window().maximize();
        Reporter.log("browser is maximized");
        driver.get("https://www.google.com");
        Reporter.log("the google website is opened");
        driver.findElement(By.name("q")).sendKeys("Hi");
        Reporter.log("the data hi is entered");

    }
}
