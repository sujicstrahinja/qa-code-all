package tests.manager;

import main.BaseTest;
import main.pages.AddNewCustomerPage;
import main.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SM36 extends BaseTest {

    @Test
    public void verifyCustomerAccountIsCreated() {
        AddNewCustomerPage addNewCustomerPage = new AddNewCustomerPage(getDriver());
        addNewCustomerPage.clickPageLink("New Customer");

        WebDriverWait shortWait = new WebDriverWait(getDriver(), 10);

        String customerName = "Virendra";
        String gender = "male";
        String birthdate = "2013-11-04";
        String address = "Jamnagar";
        String city = "Jamnagar";
        String state = "Gujarat";
        String pin = "567321";
        String mobileNo = "8000439024";
        String email = "Virendra140@gmail.com";
        String password = "sifra1@";

        addNewCustomerPage.fillAndSubmitAddNewCustomerForm(customerName, gender, birthdate, address, city, state, pin, mobileNo, email, password);
        String customerId = getDriver().findElement(By.cssSelector("table.layout:nth-child(8) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(2)")).getText();

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,500)");
        shortWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[contains(@id, 'primis_playerSekindoSPlayer')]")));
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[contains(@id, 'Video-iFrame-SekindoSPlayer')]")));
        shortWait.until(ExpectedConditions.elementToBeClickable(By.id("closeBtn")));
        getDriver().findElement(By.id("closeBtn")).click();
        getDriver().switchTo().defaultContent();
        jse.executeScript("window.scrollBy(0,-500)");
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
//        UNREACHABLE LINK ON THE WEBSITE
        addNewCustomerPage.clickPageLink("Log out");

        shortWait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("uid")));

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(customerId, password);
    }
}
