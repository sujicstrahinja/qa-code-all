package tests;

import main.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SR1 extends Driver {

    private static String baseUrl= "";

    public static void main(String[] args) {

        initialize("chrome");

        baseUrl = properties.getProperty("baseUrl");
        driver.get(baseUrl);

        int thisIsDemoSiteShownCount = driver.findElements(By.xpath("//div[@class='page-title']/h2[contains(text(), 'This is demo site for')]")).size();
        boolean isThisIsDemoSiteShown = false;
        if(thisIsDemoSiteShownCount == 1) { isThisIsDemoSiteShown = true; }
        Assert.assertTrue(isThisIsDemoSiteShown);

        verifyTitle("Home page");

        WebElement mobileLink = driver.findElement(By.linkText("MOBILE"));
        mobileLink.click();

        verifyTitle("Mobile");

        Select sortBy = new Select(driver.findElement(By.cssSelector("select[title='Sort By']")));
        sortBy.selectByVisibleText("Name");

        List<WebElement> productNameElements = driver.findElements(By.xpath("//h2[@class='product-name']/a"));
        ArrayList<String> productNames = new ArrayList<>();
        populateList(productNameElements, productNames);

        ArrayList<String> sortedProductNames = new ArrayList<>();
        populateList(productNameElements, sortedProductNames);
        Collections.sort(sortedProductNames);

        Assert.assertEquals(productNames, sortedProductNames);

        teardown();
    }

    private static void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    private static void populateList(List<WebElement> fromWebElementsList, ArrayList<String> toStringList) {
        for (WebElement we : fromWebElementsList) {
            toStringList.add(we.getText());
        }
    }
}
