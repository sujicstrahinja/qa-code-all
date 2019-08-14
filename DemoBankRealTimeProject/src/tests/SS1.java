package tests;

import main.DataProviderClass;
import main.Driver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class SS1 extends Driver {

    private static String baseUrl = "";

    @BeforeTest
    public void initialize() {
        initialize("firefox");
    }

    @Test(dataProvider = "LoginCredentialsProvider", dataProviderClass = DataProviderClass.class)
    public void verifyLoginValidAndInvalidCases(String username, String password) throws IOException {

        baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

            WebElement userIdInput = driver.findElement(By.name("uid"));
            WebElement passwordInput = driver.findElement(By.name("password"));
            WebElement loginButton = driver.findElement(By.name("btnLogin"));

            userIdInput.sendKeys(username);
            passwordInput.sendKeys(password);
            loginButton.click();

            try {
                Alert alert = driver.switchTo().alert();

                String expectedAlertText = "User or Password is not valid";
                String actualAlertText = alert.getText();
                Assert.assertEquals(expectedAlertText, actualAlertText);
                driver.switchTo().alert().dismiss();
            } catch (NoAlertPresentException e) {

                int managerIdTextCount = driver.findElements(By.xpath("//td[text()='Manger Id : " + username + "']")).size();
                Assert.assertEquals(managerIdTextCount, 1);

                TakesScreenshot screenshot =((TakesScreenshot)driver);
                File screenshotFileFrom = screenshot.getScreenshotAs(OutputType.FILE);
                String savePath = System.getProperty("user.dir")+"\\Screenshots\\screenshot-of-" + username + ".png";
                File screenshotFileTo = new File(savePath);
                FileUtils.copyFile(screenshotFileFrom, screenshotFileTo);

                String actualTitle = driver.getTitle();
                String expectedTitle = "Guru99 Bank Manager HomePage";
                Assert.assertEquals(actualTitle, expectedTitle);
            }

            driver.get(baseUrl);
    }

    @AfterTest
    public void clearBrowser() {
        teardown();
    }
}
