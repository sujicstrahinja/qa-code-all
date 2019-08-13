package tests;

import main.Driver;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SS1 extends Driver {

    private static String baseUrl = "";
    private static String username = "";
    private static String password = "";

    @BeforeTest
    public void initialize() {
        initialize("firefox");
    }

    @Test
    public void verifyLoginValidAndInvalidCases() throws IOException {

        Properties properties = new Properties();
        FileInputStream propertiesPath = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\settings.properties");
        properties.load(propertiesPath);

        baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

        String fileName = "parameters.xlsx";
        String sheetName = "Sheet1";
        String filePath = System.getProperty("user.dir")+"\\src\\resources";
        File file = new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet firstSheet = workbook.getSheet(sheetName);
//        int firstSheetRowCount = firstSheet.getLastRowNum()-firstSheet.getFirstRowNum();

        for (int i = 1; i < firstSheet.getLastRowNum()+1; i++) {
            Row row = firstSheet.getRow(i);

            username = row.getCell(1).getStringCellValue();
            password = row.getCell(2).getStringCellValue();

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

                int welcomeTextCount = driver.findElements(By.cssSelector("marquee[class='heading3']")).size();
                Assert.assertEquals(welcomeTextCount, 1);

                String actualTitle = driver.getTitle();
                String expectedTitle = "Guru99 Bank Manager HomePage";
                Assert.assertEquals(actualTitle, expectedTitle);
            }

            driver.get(baseUrl);
        }
    }

    @AfterTest
    public void clearBrowser() {
        teardown();
    }

}
