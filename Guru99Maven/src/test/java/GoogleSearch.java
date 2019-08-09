import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class GoogleSearch extends Base {

    private String baseUrl  = "https://www.google.com/";
    private WebDriverWait shortWait = null;

    @Test(priority = 0)
    public void openBrowser() {
        initialize("firefox");
        shortWait = new WebDriverWait(driver, 3);
    }

    @Test(priority = 1)
    public void launchGoogle() {
        driver.get(baseUrl);
    }

    @Test(priority = 2)
    public void performSearchAndClick1stLink() {
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Facebook");
        search.sendKeys(Keys.ENTER);

        int x = 0;
        Assert.assertEquals(x, 0);
    }

    @Test(priority = 3)
    public void FaceBookPageTitleVerification() {
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".q.qs")));

        String expectedTitle = "Facebook - Google претрага";
        boolean doesActualTitleEqualToExpectedTitle = driver.getTitle().equals(expectedTitle);
        Assert.assertTrue(doesActualTitleEqualToExpectedTitle);
    }

    @AfterTest
    public void cleanUp() {
        teardown();
    }
}
