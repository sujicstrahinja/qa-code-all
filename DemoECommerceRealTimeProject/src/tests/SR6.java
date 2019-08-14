package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SR6 extends Driver {

    private static String baseUrl= "";

    public static void main(String[] args) {

        initialize("chrome");

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

        WebElement myWishlistLink = driver.findElement(By.linkText("MY WISHLIST"));
        myWishlistLink.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        addToCartButton.click();

        WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//span[text()='Proceed to Checkout']"));
        proceedToCheckoutButton.click();

//        FOR PROFILES THAT HAVEN'T YET MADE A PURCHASE
//        WebElement addressInput = driver.findElement(By.id("billing:street1"));
//        WebElement cityInput = driver.findElement(By.id("billing:city"));
//        Select stateDropdown = new Select(driver.findElement(By.id("billing:region_id")));
//        WebElement zipInput = driver.findElement(By.id("billing:postcode"));
//        Select countryDropdown = new Select(driver.findElement(By.id("billing:country_id")));
//        WebElement telephoneInput = driver.findElement(By.id("billing:telephone"));
//
//        addressInput.sendKeys("ABC");
//        cityInput.sendKeys("New York");
//        stateDropdown.selectByVisibleText("New York");
//        zipInput.sendKeys("542896");
//        countryDropdown.selectByVisibleText("United States");
//        telephoneInput.sendKeys("12345678");

        List<WebElement> continueButtons = driver.findElements(By.xpath("//span[text()='Continue']"));
        continueButtons.get(0).click();

        String expectedGeneratedRate = driver.findElement(By.xpath("//label[@for='s_method_flatrate_flatrate']/span")).getText();

        continueButtons.get(2).click();

        String actualGeneratedRate = driver.findElement(By.xpath("//div[@id='shipping_method-progress-opcheckout']/dd/span")).getText();
        Assert.assertEquals(actualGeneratedRate, expectedGeneratedRate);
        WebElement checkMoneyOrderCheckbox = driver.findElement(By.id("p_method_checkmo"));
        checkMoneyOrderCheckbox.click();

        continueButtons.get(3).click();

        String subtotalPriceAsText = driver.findElement(By.xpath("//tr[@class='first']/td[2]/span")).getText();
        String grantTotalPriceAsText = driver.findElement(By.xpath("//tr[@class='last']/td[2]/strong/span")).getText();
        int subtotal = Integer.parseInt(subtotalPriceAsText.split("\\.")[0].substring(1).replace(",", ""));
        int grantTotal = Integer.parseInt(grantTotalPriceAsText.split("\\.")[0].substring(1).replace(",", ""));
        int shipping = Integer.parseInt(actualGeneratedRate.split("\\.")[0].substring(1).replace(",", ""));
        Assert.assertEquals(grantTotal, subtotal+shipping);

        WebElement placeOrderButton = driver.findElement(By.xpath("//span[text()='Place Order']"));
        placeOrderButton.click();

        int orderReceivedTextCount = driver.findElements(By.xpath("//h1[text()='Your order has been received.']")).size();
        Assert.assertEquals(orderReceivedTextCount, 1);

        String orderNumber = driver.findElement(By.xpath("//a[contains(@href, 'http://live.guru99.com/index.php/sales/order/view/order_id')]")).getText();
        System.out.println(orderNumber);

        teardown();
    }
}
