package tests.customer;

import main.BaseTest;
import main.pages.CustomisedStatementPage;
import main.pages.FundTransferPage;
import main.pages.MiniStatementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SC8 extends BaseTest {

    private String transactionId = "";

    @Test(priority = 0)
    public void verifyFundTransfers() {
        FundTransferPage fundTransferPage = new FundTransferPage(getDriver());
        fundTransferPage.clickPageLink("Fund Transfer");

        String payersAccountNo = "72182";
        String payeesAccountNo = "72183";
        String amount = "1";
        String description = "cash";

        fundTransferPage.fillAndSubmitForm(payersAccountNo, payeesAccountNo, amount, description);

        String fromAccountNumberActualValue = getDriver().findElement(By.cssSelector("table.layout1:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) > td:nth-child(2)")).getText();
        String toAccountNumberActualValue = getDriver().findElement(By.cssSelector("table.layout1:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(2)")).getText();
        String descriptionActualValue = getDriver().findElement(By.cssSelector("table.layout1:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(5) > td:nth-child(2)")).getText();
        String amountActualValue = getDriver().findElement(By.cssSelector("table.layout1:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(2)")).getText();
        Assert.assertEquals(fromAccountNumberActualValue, payersAccountNo);
        Assert.assertEquals(toAccountNumberActualValue, payeesAccountNo);
        Assert.assertEquals(amountActualValue, amount);
        Assert.assertEquals(descriptionActualValue, description);

        this.transactionId = getDriver().findElement(By.cssSelector("table.layout1:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) > td:nth-child(2)")).getText();
    }

    @Test(priority = 1, dependsOnMethods = "verifyFundTransfers")
    public void verifyFundTransferIsNotDoneAgainWhenPageIsReloaded() {
        getDriver().navigate().refresh();
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("payersaccount")));
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.demo.guru99.com/V4/customer/customerfundinput.php");
    }

    @Test(priority = 2, dependsOnMethods = "verifyFundTransfers")
    public void verifyTransferDetailsAppearOnTheCustomizedStatement() {
        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        customisedStatementPage.clickPageLink("Customised Statement");

        String payersAccountNo = "72182";
        String currentDate = String.valueOf(java.time.LocalDate.now());

        customisedStatementPage.fillFormAndSubmit(payersAccountNo, "", currentDate, "", "");
        List<WebElement> transactionRows = getDriver().findElements(By.xpath("//tr//tr"));
        boolean isCustomisedStatement = false;
        for (int i = 1; i < transactionRows.size()-1; i++) {
            int transactionIndex = ++i;
            String actualTransactionID = getDriver().findElement(By.cssSelector("table.layout1:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child("+transactionIndex+") > td:nth-child(1)")).getText();

            if (actualTransactionID.equals(this.transactionId)) {
                isCustomisedStatement = true;
                break;
            }
        }

        Assert.assertTrue(isCustomisedStatement);
    }

//    DON'T HAVE AN ACCOUNT/ DOESN'T SHOW ALERT ON WEBSITE
    @Test(priority = 3, enabled = false)
    public void verifyFundTransferForPayerAuthorization () {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Fund Transfer")));
        FundTransferPage fundTransferPage = new FundTransferPage(getDriver());
        fundTransferPage.clickPageLink("Fund Transfer");

        String payersAccountNo = "72182";
        String payeesAccountNo = "72184";
        String amount = "1";
        String description = "cash";

        fundTransferPage.fillAndSubmitForm(payersAccountNo, payeesAccountNo, amount, description);

        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "You are not authorize to do fund transfer!!");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority = 4)
    public void verifyFundTransferPayerOrPayeeAccountNoDoesNotExistInDatabase() {
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
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account "+payersAccountNo+" does not exist!!!");
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
}
