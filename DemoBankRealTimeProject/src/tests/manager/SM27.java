package tests.manager;

import main.BaseTest;
import main.pages.BalanceEnquiryPage;
import main.pages.MiniStatementPage;
import main.pages.WithdrawalPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SM27 extends BaseTest {

    private String accountNo = "71644";
    private String amount = "5";
    private String description = "cash";
    private String currentBalance = "";

    @Test
    public void verifyWithdrawal() {
        BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage(getDriver());
        balanceEnquiryPage.clickPageLink("Balance Enquiry");
        balanceEnquiryPage.fillFormAndSubmit(this.accountNo);
        this.currentBalance = balanceEnquiryPage.getCurrentBalance();

        WithdrawalPage withdrawalPage = new WithdrawalPage(getDriver());
        withdrawalPage.clickPageLink("Withdrawal");

        withdrawalPage.fillAndSubmitForm(this.accountNo, this.amount, this.description);

        Assert.assertEquals(Integer.parseInt(this.currentBalance)-Integer.parseInt(this.amount), Integer.parseInt(withdrawalPage.getCurrentBalance()));
    }

    @Test
    public void verifyWithdrawalCannotBeMadeIfRequestedAmountIsMoreThanCurrentAmountInTheAccount() {
        WithdrawalPage withdrawalPage = new WithdrawalPage(getDriver());
        withdrawalPage.clickPageLink("Withdrawal");

        String amount = "1600000000";

        withdrawalPage.fillAndSubmitForm(this.accountNo, amount, this.description);
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Transaction Failed. Account Balance Low!!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("accountno")));
    }

    @Test(dependsOnMethods = "verifyWithdrawal")
    public void verifyMiniStatement() {
        MiniStatementPage miniStatementPage = new MiniStatementPage(getDriver());
        miniStatementPage.clickPageLink("Mini Statement");

        miniStatementPage.fillFormAndSubmit(this.accountNo);

        List<WebElement> transactionRows = getDriver().findElements(By.xpath("//tr//tr"));
        boolean isMiniStatementFound = false;
        for (int i = 1; i < transactionRows.size()-1; i++) {
            String actualAmount = transactionRows.get(i).findElement(By.xpath("//td[2]")).getText();
            String actualTransactionType = transactionRows.get(i).findElement(By.xpath("//td[3]")).getText();
            String actualDate =  transactionRows.get(i).findElement(By.xpath("//td[4]")).getText();
            String actualDescription = transactionRows.get(i).findElement(By.xpath("//td[5]")).getText();

            String currentDate = String.valueOf(java.time.LocalDate.now());

            if(actualAmount.equals(this.amount) &&
            actualTransactionType.equals("w") &&
            actualDate.equals(currentDate) &&
            actualDescription.equals(this.description)) {
                isMiniStatementFound = true;
                break;
            }
        }

        Assert.assertTrue(isMiniStatementFound);
    }

    @Test(dependsOnMethods = "verifyWithdrawal")
    public void verifyBalance() {
        BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage(getDriver());
        balanceEnquiryPage.clickPageLink("Balance Enquiry");
        balanceEnquiryPage.fillFormAndSubmit(this.accountNo);
        String currentBalance = balanceEnquiryPage.getCurrentBalance();

        Assert.assertEquals(Integer.parseInt(currentBalance), Integer.parseInt(this.currentBalance)-Integer.parseInt(this.amount));
    }
}
