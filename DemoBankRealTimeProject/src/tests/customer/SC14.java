package tests.customer;

import main.BaseTest;
import main.pages.MiniStatementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SC14 extends BaseTest {

    @Test
    public void verifyACustomerCanSeeMiniStatementOfOnlyHisAccount() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        MiniStatementPage miniStatementPage = new MiniStatementPage(getDriver());
        miniStatementPage.clickPageLink("Mini Statement");

        String accountNo = "71644";

        miniStatementPage.fillFormAndSubmit(accountNo);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "You are not authorize to generate statement of this Account!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mini Statement")));
    }

    @Test
    public void verifySystemBehaviorWhenWrongAccountNumberIsEnteredInTheMiniStatement() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        MiniStatementPage miniStatementPage = new MiniStatementPage(getDriver());
        miniStatementPage.clickPageLink("Mini Statement");

        String accountNo = "7164444444";

        miniStatementPage.fillFormAndSubmit(accountNo);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account does not exist");
        getDriver().switchTo().alert().dismiss();
    }
}
