import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class ActionsHover {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        Actions execute = new Actions(driver);
        WebElement searchInput = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        execute.click(searchInput).keyUp(Keys.SHIFT).sendKeys("hello").build().perform();
        execute.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build().perform();
//        execute.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-shopall']"))).build().perform();
    }
}
