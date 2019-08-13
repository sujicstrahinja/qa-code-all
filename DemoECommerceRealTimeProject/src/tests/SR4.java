package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SR4 extends Driver {

    private static String baseUrl= "";

    public static void main(String[] args) {

        initialize("chrome");

        baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

        WebElement mobileLink = driver.findElement(By.linkText("MOBILE"));
        mobileLink.click();

        List<WebElement> addToCompareLinks = driver.findElements(By.className("link-compare"));
        addToCompareLinks.get(0).click();
        addToCompareLinks = driver.findElements(By.className("link-compare"));
        addToCompareLinks.get(1).click();

        List<WebElement> compareProducts = driver.findElements(By.xpath("//p[@class='product-name']/a"));
        ArrayList<String> compareProductLinks = new ArrayList<String>();
        for (WebElement compareProduct : compareProducts) {
            compareProductLinks.add(compareProduct.getAttribute("href"));
        }
        
        WebElement compareButton = driver.findElement(By.xpath("//span[text()= 'Compare']"));
        compareButton.click();

        Set<String> tabIds = driver.getWindowHandles();
        Iterator<String> currentlyPointedId = tabIds.iterator();
        String mainTab = currentlyPointedId.next();
        String compareTab = currentlyPointedId.next();
        driver.switchTo().window(compareTab);

        int compareProductsTextCount = driver.findElements(By.xpath("//h1[text()= 'Compare Products']")).size();
        Assert.assertEquals(compareProductsTextCount, 1);
        for (String compareProductLink : compareProductLinks) {
            Assert.assertTrue(driver.getPageSource().contains(compareProductLink));
        }
        driver.getPageSource();
        driver.close();
        driver.switchTo().window(mainTab);
        tabIds = driver.getWindowHandles();
        Assert.assertEquals(tabIds.size(), 1);

        teardown();
    }
}