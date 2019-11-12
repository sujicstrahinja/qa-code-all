package tests.manager;

import main.BaseTest;
import main.pages.FundTransferPage;
import main.pages.MiniStatementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM16 extends BaseTest {

    private String payersAccountNo = "";

    @Test(priority = 0)
    public void verifyFundTransfers() {
        FundTransferPage fundTransferPage = new FundTransferPage(getDriver());
        fundTransferPage.clickPageLink("Fund Transfer");

        String payersAccountNo = "71644";
        String payeesAccountNo = "71645";
        String amount = "1";
        String description = "cash";

        fundTransferPage.fillAndSubmitForm(payersAccountNo, payeesAccountNo, amount, description);

        String fromAccountNumberActualValue = getDriver().findElement(By.cssSelector("table.layout:nth-child(11) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) > td:nth-child(2)")).getText();
        String toAccountNumberActualValue = getDriver().findElement(By.cssSelector("table.layout:nth-child(11) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(2)")).getText();
        String descriptionActualValue = getDriver().findElement(By.cssSelector("table.layout:nth-child(11) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(2)")).getText();
        String amountActualValue = getDriver().findElement(By.cssSelector("table.layout:nth-child(11) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) > td:nth-child(2)")).getText();
        Assert.assertEquals(fromAccountNumberActualValue, payersAccountNo);
        Assert.assertEquals(toAccountNumberActualValue, payeesAccountNo);
        Assert.assertEquals(amountActualValue, amount);
        Assert.assertEquals(descriptionActualValue, description);
    }

    @Test(priority = 1, dependsOnMethods = "verifyFundTransfers")
    public void verifyFundTransferIsNotDoneAgainWhenPageIsReloaded() {
        getDriver().navigate().refresh();
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("payersaccount")));
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.demo.guru99.com/V4/manager/FundTransInput.php");
    }

//    THEY HAVEN'T GIVEN THE VARIABLE WITH WHICH TO SEARCH EXISTING TRANSACTIONS
    @Test(priority = 2, enabled = false)
    public void verifyTransferDetailsAppearOnTheCustomizedStatement() {
        MiniStatementPage miniStatementPage = new MiniStatementPage(getDriver());
        miniStatementPage.clickPageLink("Mini Statement");
    }

    @Test(priority = 3)
    public void verifySystemBehaviorWhenManagerEntersWrongAccountNumberDuringFundTransfer() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Fund Transfer")));
        FundTransferPage fundTransferPage = new FundTransferPage(getDriver());
        fundTransferPage.clickPageLink("Fund Transfer");

        String payersAccountNo = "71644555511";
        String payeesAccountNo = "71645";
        String amount = "1";
        String description = "cash";

        fundTransferPage.fillAndSubmitForm(payersAccountNo, payeesAccountNo, amount, description);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account "+payersAccountNo+"does not exist!!!");
        getDriver().switchTo().alert().dismiss();
    }

//    BUGS ON WEBSITE, DOESN'T SHOW ALERT
    @Test(priority = 4, enabled = false)
    public void verifySystemBehaviorWhenManagerWantsToTransferFundToAnAccountNotUnderHisSupervision() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Fund Transfer")));
        FundTransferPage fundTransferPage = new FundTransferPage(getDriver());
        fundTransferPage.clickPageLink("Fund Transfer");

        String payersAccountNo = "71644";
        String payeesAccountNo = "71651";
        String amount = "1";
        String description = "cash";

        fundTransferPage.fillAndSubmitForm(payersAccountNo, payeesAccountNo, amount, description);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "You are not authorize to do fund transfer!!");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority = 5)
    public void verifyFundTransferForSameAccountNumbers() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Fund Transfer")));
        FundTransferPage fundTransferPage = new FundTransferPage(getDriver());
        fundTransferPage.clickPageLink("Fund Transfer");

        String payersAccountNo = "71644";
        String payeesAccountNo = "71644";
        String amount = "1";
        String description = "cash";

        fundTransferPage.fillAndSubmitForm(payersAccountNo, payeesAccountNo, amount, description);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Payers account No and Payees account No Must Not be Same!!!");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority = 6)
    public void verifyFundTransferWhenAccountBalanceIsLow() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Fund Transfer")));
        FundTransferPage fundTransferPage = new FundTransferPage(getDriver());
        fundTransferPage.clickPageLink("Fund Transfer");

        String payersAccountNo = "71644";
        String payeesAccountNo = "71645";
        String amount = "1000000";
        String description = "cash";

        fundTransferPage.fillAndSubmitForm(payersAccountNo, payeesAccountNo, amount, description);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Transfer Failed. Account Balance low!!");
        getDriver().switchTo().alert().dismiss();
    }
}
