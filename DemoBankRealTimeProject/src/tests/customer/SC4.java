package tests.customer;

import main.BaseTest;
import main.pages.BalanceEnquiryPage;
import main.pages.ManagerHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SC4 extends BaseTest {

    @Test
    public void verifyBalanceOfAnAccount() {
        ManagerHomePage managerHomePage = new ManagerHomePage(getDriver());
        managerHomePage.clickPageLink("Balance Enquiry");

        BalanceEnquiryPage balanceEnquiryPage = new BalanceEnquiryPage(getDriver());

        String accountNo = "71949";
        balanceEnquiryPage.selectAccount(accountNo);
        int balanceDetailsCount = getDriver().findElements(By.xpath("//p[text()='Balance Details for Account "+accountNo+"']")).size();
        Assert.assertEquals(balanceDetailsCount, 1);
    }
}
