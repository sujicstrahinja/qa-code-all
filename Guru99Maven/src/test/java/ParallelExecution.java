import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelExecution {

    private WebDriverWait shortWait = null;

    @Test
    public void facebookVerifyTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\chromedriver.exe");
        WebDriver driverFacebook = new ChromeDriver();
        driverFacebook.get("https://www.facebook.com/");

        Assert.assertTrue(driverFacebook.getTitle().equals("Facebook - Log In or Sign Up"));
    }

    @Test
    public void youtubeVerifyTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\chromedriver.exe");
        WebDriver driverYoutube = new ChromeDriver();
        driverYoutube.get("https://www.youtube.com/");

        Assert.assertTrue(driverYoutube.getTitle().equals("YouTube"));
    }

    @Test
    public void instagramVerifyTitle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\chromedriver.exe");
        WebDriver driverInstagram = new ChromeDriver();
        driverInstagram.get("https://www.instagram.com/");

        Assert.assertTrue(driverInstagram.getTitle().equals("Instagram"));
    }

    public void setShortWait(WebDriver driver, int seconds) {
        shortWait = new WebDriverWait(driver, seconds);
    }
}

//@Test
//public void facebookVerifyInvalidCredentialsWithAssociatedAccount() {
//    System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\chromedriver.exe");
//    WebDriver driverFacebook = new ChromeDriver();
//    driverFacebook.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    driverFacebook.get("https://www.facebook.com/");
//
//    WebElement emailInput = driverFacebook.findElement(By.id("email"));
//    WebElement passwordInput = driverFacebook.findElement(By.id("pass"));
//    WebElement loginButton = driverFacebook.findElement(By.cssSelector("input[type='submit']"));
//
//    String email = "asd";
//    String password= "sifra1";
//
//    emailInput.sendKeys(email);
//    passwordInput.sendKeys(password);
//    loginButton.click();
//
//    By recoverAccountButtonBy = By.linkText("Recover Your Account");
//    shortWait.until(ExpectedConditions.visibilityOfElementLocated(recoverAccountButtonBy));
//
//    int recoverAccountButtonCount = driverFacebook.findElements(recoverAccountButtonBy).size();
//    Assert.assertTrue(recoverAccountButtonCount == 1);
//}
