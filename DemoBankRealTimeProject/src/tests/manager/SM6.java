package tests.manager;

import main.BaseTest;
import main.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM6 extends BaseTest {

    private String accountNo = "71636";

    @Test(priority = 0)
    public void verifyConfirmationMessageIsShownOnDeletionOfAnAccount() {
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(getDriver());
        deleteAccountPage.clickPageLink("Delete Account");

        deleteAccountPage.fillFormAndSubmit(this.accountNo);
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Do you really want to delete this Account?");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority = 1)
    public void verifySystemBehaviourAfterAccountIsDeleted() throws InterruptedException {
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(getDriver());
        deleteAccountPage.clickPageLink("Delete Account");

        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);

        deleteAccountPage.fillFormAndSubmit(this.accountNo);
        shortWait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account Deleted Sucessfully");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority = 2)
    public void verifyMiniStatementIsNotGeneratedForDeletedAccount() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Mini Statement")));

        MiniStatementPage miniStatementPage = new MiniStatementPage(getDriver());
        miniStatementPage.clickPageLink("Mini Statement");
        miniStatementPage.fillFormAndSubmit(this.accountNo);
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account does not exist");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority = 3)
    public void verifyBalanceIsNotGeneratedForDeletedAccount() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Balance Enquiry")));

        BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage(getDriver());
        balanceEnquiryPage.clickPageLink("Balance Enquiry");

        balanceEnquiryPage.fillFormAndSubmit(this.accountNo);
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account does not exist");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority=  4)
    public void verifyCustomisedStatementIsNotGeneratedForDeletedAccount() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Customised Statement")));

        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        customisedStatementPage.clickPageLink("Customised Statement");

        customisedStatementPage.fillFormAndSubmit(this.accountNo, "", "", "", "");
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account does not exist");
        getDriver().switchTo().alert().dismiss();
    }
}
