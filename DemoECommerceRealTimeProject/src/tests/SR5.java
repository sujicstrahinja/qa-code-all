package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SR5 extends Driver {

    protected static String baseUrl= "";

    public static void main(String[] args) {

        initialize("chrome");

        baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

        WebElement accountDropdownLink = driver.findElement(By.xpath("//span[text()='Account']"));
        accountDropdownLink.click();

        WebElement myAccountLink = driver.findElement(By.cssSelector("a[title='My Account']"));
        myAccountLink.click();

        WebElement createAnAccountButton = driver.findElement(By.xpath("//span[text()='Create an Account']"));
        createAnAccountButton.click();

        WebElement firstNameInput = driver.findElement(By.id("firstname"));
        WebElement middleNameInput = driver.findElement(By.id("middlename"));
        WebElement lastNameInput = driver.findElement(By.id("lastname"));
        WebElement emailAddressInput = driver.findElement(By.id("email_address"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement confirmPasswordInput = driver.findElement(By.id("confirmation"));
        WebElement registerButton = driver.findElement(By.cssSelector("button[title='Register']"));

        firstNameInput.sendKeys("Djura");
        middleNameInput.sendKeys("DJ");
        lastNameInput.sendKeys("Djokovic");
        emailAddressInput.sendKeys("djura323321@gmail.com");
        passwordInput.sendKeys("sifra1");
        confirmPasswordInput.sendKeys("sifra1");
        registerButton.click();

        int thankYouForRegisteringCount = driver.findElements(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).size();
        Assert.assertEquals(thankYouForRegisteringCount, 1);

        WebElement tvLink = driver.findElement(By.cssSelector("a[href='http://live.guru99.com/index.php/tv.html']"));
        tvLink.click();

        WebElement firstTvProductWishLink = driver.findElement(By.xpath("//a[text()='Add to Wishlist']"));
        firstTvProductWishLink.click();

        WebElement shareWishlistButton = driver.findElement(By.xpath("//span[text()='Share Wishlist']"));
        shareWishlistButton.click();

        WebElement emailAddressTextarea = driver.findElement(By.id("email_address"));
        emailAddressTextarea.sendKeys("djura123321@gmail.com");

        WebElement messageTextarea = driver.findElement(By.id("message"));
        messageTextarea.sendKeys("djuro stigli televizori");

        WebElement shareWishilistSendEmailButton = driver.findElement(By.xpath("//span[text()='Share Wishlist']"));
        shareWishilistSendEmailButton.click();

        int wishlistSharedTextCount = driver.findElements(By.xpath("//span[text()='Your Wishlist has been shared.']")).size();
        Assert.assertEquals(wishlistSharedTextCount, 1);

        teardown();
    }
}
