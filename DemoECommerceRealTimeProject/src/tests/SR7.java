package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SR7 extends Driver {

    private static String baseUrl= "";

    public static void main(String[] args) {

        initialize("firefox");

        baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

        WebElement accountDropdownLink = driver.findElement(By.xpath("//span[text()='Account']"));
        accountDropdownLink.click();

        WebElement loginLink = driver.findElement(By.cssSelector("a[title='Log In']"));
        loginLink.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.id("send2"));

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        WebElement myOrdersLink = driver.findElement(By.linkText("MY ORDERS"));
        myOrdersLink.click();

        WebElement firstViewOrderLink = driver.findElement(By.linkText("View Order"));
        firstViewOrderLink.click();



//        teardown();
    }
}
