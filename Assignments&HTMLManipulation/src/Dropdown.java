import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com/");

//        Select currencySelect = new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency")));
//        driver.manage().window().maximize();
//        driver.findElement(By.id("divpaxinfo")).click();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        for (int i = 0; i < 6; i++) {
//            driver.findElement(By.cssSelector("#hrefIncAdt")).click();
//        }
//        driver.findElement(By.cssSelector("input[id='btnclosepaxoption']")).click();

        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();

//        WebElement element;
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[text='Amritsar (ATQ)']")));
        driver.findElement(By.cssSelector("a[text='Amritsar (ATQ)']")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[text='Goa (GOI)']")));

        driver.findElement(By.xpath("(//a[@text='Goa (GOI)'])[2]")).click();
    }

    public static void pause() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
