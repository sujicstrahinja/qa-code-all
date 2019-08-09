import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

    public static void main(String[] args) {

        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\strahinja\\AppData\\Local\\Programs\\Opera\\60.0.3255.70\\opera.exe");
        System.setProperty("webdriver.opera.driver", "C:\\Users\\strahinja\\Downloads\\operadriver_win64\\operadriver.exe");
        WebDriver driver = new OperaDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, 1);
        WebDriverWait longerWait = new WebDriverWait(driver, 10);

        driver.get("https://alaskatrips.poweredbygps.com/");

        WebElement originInput = driver.findElement(By.cssSelector("input[id='package-origin-hp-package']"));
        originInput.click();
        originInput.sendKeys("New York");
        originInput.sendKeys(Keys.ARROW_DOWN);
        sleep();
        originInput.sendKeys(Keys.TAB);

        WebElement destinationInput = driver.findElement(By.cssSelector("input[id='package-destination-hp-package']"));
        destinationInput.sendKeys("eugen");
        destinationInput.sendKeys(Keys.ARROW_DOWN);
        sleep();
        destinationInput.sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector("input[id='package-departing-hp-package']")).click();
        WebElement departingDateButton = driver.findElement(By.xpath("//button[@data-year='2019' and @data-month='3' and @data-day='30']"));
        wait.until(ExpectedConditions.elementToBeClickable(departingDateButton));
        departingDateButton.click();

        driver.findElement(By.cssSelector("input[id='package-returning-hp-package']")).click();
        WebElement returningDateButton = driver.findElement(By.xpath("//button[@data-year='2019' and @data-month='4' and @data-day='3']"));
        wait.until(ExpectedConditions.elementToBeClickable(returningDateButton));
        returningDateButton.click();

        driver.findElement(By.cssSelector("button[id='search-button-hp-package']")).click();

        longerWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='Eugene-Hotels-Phoenix-Inn-Suites-Eugene']")));
        driver.findElement(By.cssSelector("a[href*='Eugene-Hotels-Phoenix-Inn-Suites-Eugene']")).click();
    }

    public static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
