package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SS1 extends Driver {

    private static String baseUrl = "";
    private static String username = "";
    private static String password = "";

    public static void main(String[] args) throws IOException {

        initialize("firefox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Properties properties = new Properties();
        FileInputStream propertiesPath = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\settings.properties");
        properties.load(propertiesPath);

        baseUrl = properties.getProperty("baseUrl");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driver.get(baseUrl);

        WebElement userIdInput = driver.findElement(By.name("uid"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("btnLogin"));

        userIdInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        int welcomeTextCount = driver.findElements(By.className("marquee[class='heading3']")).size();
        boolean isWelcomeTextPresent = false;
        if (welcomeTextCount == 0) { isWelcomeTextPresent = true; }
        Assert.assertTrue(isWelcomeTextPresent);

        String actualTitle = driver.getTitle();
        String expectedTitle = " Guru99 Bank Manager HomePage ";
        Assert.assertEquals(actualTitle, expectedTitle);

        teardown();
    }
}
