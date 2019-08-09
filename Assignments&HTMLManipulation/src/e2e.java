import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class e2e {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        driver.manage().window().fullscreen();
        driver.get("https://www.spicejet.com/");
        Select currencyDropdown = new Select(driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency")));

        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#glsctl00_mainContent_ddl_originStation1_CTNR")));
        driver.findElement(By.cssSelector("a[value='BLR']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR")));
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-datepicker-div")));
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("opacity: 0.5"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='ui-datepicker-div']")));
        driver.findElement(By.cssSelector("div#divpaxinfo")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span#hrefIncAdt")));
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.cssSelector("span#hrefIncAdt")).click();
        }
        driver.findElement(By.cssSelector("input#btnclosepaxoption")).click();

        currencyDropdown.selectByValue("USD");

        driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
    }
}
