import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParallelExecutionWithDataProvider {

    @Test(dataProvider = "getGoogleSearchData")
    public void googleSearch(String searchKey) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "https://google.com";

        driver.get(baseUrl);

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(searchKey);
        searchInput.sendKeys(Keys.ENTER);
    }

    @DataProvider(parallel = true)
    public Object[][] getGoogleSearchData(){
        return new Object[][]
            {
                    { "Australia" },
                    { "Europe" }
            };
    }
}
