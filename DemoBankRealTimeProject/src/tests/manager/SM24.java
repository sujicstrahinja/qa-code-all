package tests.manager;

import main.BaseTest;
import main.pages.BalanceEnquiryPage;
import main.pages.DepositPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM24 extends BaseTest {

    private String accountNo = "71644";

    @Test(priority = 0)
    public void verifyDepositCanBeMadeToAnotherAccount() {
        BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage(getDriver());
        balanceEnquiryPage.clickPageLink("Balance Enquiry");
        balanceEnquiryPage.fillFormAndSubmit(this.accountNo);
        String currentBalance = balanceEnquiryPage.getCurrentBalance();

        DepositPage depositPage = new DepositPage(getDriver());
        depositPage.clickPageLink("Deposit");

        String amount = "5";
        String description = "cash";

        depositPage.fillAndSubmitForm(this.accountNo, amount, description);

        Assert.assertEquals(Integer.parseInt(currentBalance)+Integer.parseInt(amount), Integer.parseInt(depositPage.getCurrentBalance()));
    }

    @Test(priority = 1, dependsOnMethods = "verifyDepositCanBeMadeToAnotherAccount")
    public void verifyDepositCannotBeMadeByReloadingTheDepositDetailPage() {
        getDriver().navigate().refresh();
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("accountno")));
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.demo.guru99.com/V4/manager/DepositInput.php");
    }
}
