package tests.manager;

import main.BaseTest;
import main.pages.ManagerHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM35 extends BaseTest {

    @Test
    public void verifyLogOut() {
        ManagerHomePage managerHomePage = new ManagerHomePage(getDriver());
        managerHomePage.clickPageLink("Log out");

        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "You Have Succesfully Logged Out!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("uid")));
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.demo.guru99.com/V4/index.php");
    }
}
