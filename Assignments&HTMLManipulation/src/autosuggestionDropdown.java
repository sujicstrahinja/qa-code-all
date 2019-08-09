import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class autosuggestionDropdown {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 3);

        driver.get("https://ksrtc.in/oprs-web/");

        driver.findElement(By.cssSelector("input[id='fromPlaceName']")).sendKeys("BENG");
        driver.findElement(By.cssSelector("input[id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("input[id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.cssSelector("input[id='fromPlaceName']")).sendKeys(Keys.ENTER);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String jseGetLeavingFromValue = "document.getElementById(\"fromPlaceName\");";
        jse.executeScript(jseGetLeavingFromValue);

//        driver.findElement(By.cssSelector("input[id='fromPlaceName']")).sendKeys("BEN");
//        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath(".//ul[@id='ui-id-1']")), "display", "block"));
//        List<WebElement> destinations = driver.findElements(By.xpath(".//ul[@id='ui-id-1']//a"));
//        System.out.println(destinations.size());
//        for (int i = 0; i < destinations.size(); i++) {
//            System.out.println(destinations.get(i).getText());
//            if (destinations.get(i).getText().equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
//                destinations.get(i).click();
//                System.out.println("BENGALURU INTERNATION AIRPORT is in the list");
//                break;
//            }
//            if (i == destinations.size()-1) System.out.println("BENGALURU INTERNATION AIRPORT is not in the list");
//        }
    }
}
