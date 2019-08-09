import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class SuggestiveDropdown {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        driver.get("https://www.makemytrip.com/");

        driver.findElement(By.cssSelector("input[id='fromCity']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#react-autowhatever-1")));
        driver.findElement(By.cssSelector("input.react-autosuggest__input.react-autosuggest__input--open")).sendKeys("del");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[id='react-autowhatever-1-section-0-item-0']")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("li[id='react-autowhatever-1-section-0-item-0']")).click();
    }
}
