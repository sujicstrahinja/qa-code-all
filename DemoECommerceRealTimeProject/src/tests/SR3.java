package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SR3 extends Driver {

    private static String baseUrl= "";

    public static void main(String[] args) {

        initialize("chrome");

        baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

        WebElement mobileLink = driver.findElement(By.linkText("MOBILE"));
        mobileLink.click();

        WebElement sonyXperiaAddToCartButton = driver.findElement(By.xpath("//a[@href='http://live.guru99.com/index.php/mobile/sony-xperia.html']//following-sibling::div[1]/div[@class='actions']/button"));
        sonyXperiaAddToCartButton.click();

        WebElement quantityInputField = driver.findElement(By.cssSelector("input[class='input-text qty']"));
        quantityInputField.clear();
        quantityInputField.sendKeys("1000");

        WebElement updateButton = driver.findElement(By.cssSelector("button[class='button btn-update']"));
        updateButton.click();

        int errorMessageCount = driver.findElements(By.cssSelector("p[class='item-msg error']")).size();
        Assert.assertEquals(errorMessageCount, 1);

        WebElement emptyCartButton = driver.findElement(By.id("empty_cart_button"));
        emptyCartButton.click();

        int shoppingCartEmptyTextCount = driver.findElements(By.xpath("//h1[contains(text(), 'Shopping Cart is Empty')]")).size();
        Assert.assertEquals(shoppingCartEmptyTextCount, 1);

        teardown();
    }
}
