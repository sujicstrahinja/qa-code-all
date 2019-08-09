import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment7 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        driver.get("http://www.qaclickacademy.com/practice.php");
        WebElement autocompleteInput = driver.findElement(By.cssSelector("#autocomplete"));
        autocompleteInput.sendKeys("CUB");
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("ul[id='ui-id-1']")), "display", "block"));

        autocompleteInput.sendKeys(Keys.ARROW_DOWN);
        autocompleteInput.sendKeys(Keys.ENTER);
    }
}
