package tests.manager;

import main.BaseTest;
import main.pages.EditAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM34 extends BaseTest {

    private String accountNo = "71644";

    @Test
    public void verifyEditAccount() {
        EditAccountPage editAccountPage = new EditAccountPage(getDriver());
        editAccountPage.clickPageLink("Edit Account");

        editAccountPage.fillFormAndSubmit(this.accountNo);
        String typeOfAccount = new Select(getDriver().findElement(By.name("a_type"))).getFirstSelectedOption().getAttribute("value");
        String balance = getDriver().findElement(By.name("txtinitdep")).getAttribute("value");
        Assert.assertEquals("Savings", typeOfAccount);
        Assert.assertEquals("959", balance);
    }
}
