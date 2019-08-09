import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Scope {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());

        WebElement firstColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(firstColumn.findElements(By.tagName("a")).size());

        String openInNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
        for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {

            firstColumn.findElements(By.tagName("a")).get(i).sendKeys(openInNewTab);
        }

        Thread.sleep(4000L);

        Set<String> tabIds = driver.getWindowHandles();
        Iterator<String> currentTabId = tabIds.iterator();

        while (currentTabId.hasNext()) {
            driver.switchTo().window(currentTabId.next());
            System.out.println(driver.getTitle());
        }

//        String title = driver.getCurrentUrl();
//        WebDriverWait wait = new WebDriverWait(driver, 1);
//
//        for (int i = 0; i < 5; i++) {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gf-BIG")));
//
//            footer = driver.findElement(By.id("gf-BIG"));
//            firstColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
//            WebElement link = firstColumn.findElements(By.tagName("a")).get(i);
//            String linkText = link.getText();
//            link.click();
//
//            if(!driver.getCurrentUrl().contains(title)) System.out.println(linkText + " opened a new window/tab!");
//            driver.navigate().back();
//        }
    }
}
