package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SR2 extends Driver {

    public static void main(String[] args) throws IOException {

        initialize("firefox");

        Properties properties = new Properties();
        FileInputStream propertiesPath = new FileInputStream(System.getProperty("user.dir")+"\\src\\resources\\settings.properties");
        properties.load(propertiesPath);

        String baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

        WebElement mobileLink = driver.findElement(By.linkText("MOBILE"));
        mobileLink.click();

        String sonyXperiaPrice = driver.findElement(By.xpath("//h2[@class='product-name']/a[text()='Sony Xperia']//ancestor::div[1]//span/span[@class='price']")).getText();
        WebElement sonyXperiaLink = driver.findElement(By.cssSelector("a[href='http://live.guru99.com/index.php/mobile/sony-xperia.html']"));
        sonyXperiaLink.click();

        String sonyXperiaDetailsPrice = driver.findElement(By.cssSelector("span[class='price']")).getText();
        Assert.assertEquals(sonyXperiaPrice, sonyXperiaDetailsPrice);

        teardown();
    }
}
