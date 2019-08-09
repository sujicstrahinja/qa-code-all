import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Assigment1 {

    private static WebDriver driver;

    public static void main(String[] args) {
        setupFirefox(driver);
        doTest();
        setupChrome(driver);
        doTest();
    }

    public static void setupFirefox(WebDriver driver) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        Assigment1.driver = new FirefoxDriver();
    }

    public static void setupChrome(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        Assigment1.driver = new ChromeDriver();
    }

    public static void doTest() {
        driver.get("http://www.qaclickacademy.com/practice.php");

        WebElement firstCheckbox = driver.findElement(By.cssSelector("input#checkBoxOption1"));

        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected());
        firstCheckbox.click();
        Assert.assertFalse(firstCheckbox.isSelected());
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        driver.quit();
    }
}
