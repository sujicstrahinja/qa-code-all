package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SS1 extends Driver {

    public static void main(String[] args) throws IOException {

        initialize("firefox");

        String baseUrl = "http://www.demo.guru99.com/V4/";
        driver.get(baseUrl);

        Properties properties = new Properties();
        FileInputStream propertiesPath = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\settings.properties");
        properties.load(propertiesPath);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

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

        teardown();
    }
}
