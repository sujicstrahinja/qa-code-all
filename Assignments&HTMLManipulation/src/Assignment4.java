import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Assignment4 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);
        Set<String> tabIds = driver.getWindowHandles();
        Iterator<String> currentlyPointedTadId = tabIds.iterator();

        String rootTabId = currentlyPointedTadId.next();
        String firstOpenedTabId = currentlyPointedTadId.next();
        driver.switchTo().window(firstOpenedTabId);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.switchTo().window(rootTabId);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
