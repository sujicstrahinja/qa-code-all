import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class AutoITTest extends Base {

    @BeforeTest
    public void startBrowser() {
        initialize("firefox");
    }

    @Test
    public void uploadFile() throws IOException {

        String baseUrl = "https://the-internet.herokuapp.com/upload";
        driver.get(baseUrl);

        WebElement fileBrowseButton = driver.findElement(By.id("file-upload"));
//        fileBrowseButton.click();
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", fileBrowseButton);

        Runtime.getRuntime().exec("C:\\Users\\sujic\\Documents\\AutoITScripts\\InternetHerokuAppUpload.exe");

        WebElement fileUploadButton = driver.findElement(By.id("file-submit"));
        fileUploadButton.click();

        int fileUploadedTextCount = driver.findElements(By.xpath("//div[@id='content']/div/h3")).size();
        Assert.assertEquals(fileUploadedTextCount, 1);
    }
}
