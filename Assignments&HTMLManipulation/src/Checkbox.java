import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Checkbox {

    public static final String EXPECTED_NUMBER_OF_PASSENGERS = "1 Adult";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 1);

        driver.get("https://www.spicejet.com/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        System.out.println(driver.findElements(By.xpath("//div[@id='discount-checkbox'] //input[@type='checkbox']")).size());
//        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

//        driver.findElement(By.cssSelector("div#divpaxinfo]")).click();

        Assert.assertEquals(EXPECTED_NUMBER_OF_PASSENGERS, driver.findElement(By.cssSelector("div#divpaxinfo")).getText());
    }
}
