package tests.manager;

import main.BaseTest;
import main.pages.DeleteCustomerPage;
import main.pages.EditCustomerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM11 extends BaseTest {

    private String customerId = "12146";

    @Test(priority = 0)
    public void verifyConfirmationMessageIsShownWhenCustomerIsDeleted() {
        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(getDriver());
        deleteCustomerPage.clickPageLink("Delete Customer");

        deleteCustomerPage.fillFormAndSubmit(this.customerId);
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Do you really want to delete this Customer?");
        getDriver().switchTo().alert().dismiss();
    }

    @Test(priority = 1)
    public void verifyThatCustomerShouldNotBeDeletedIfAnyAccountsExistsForThatCustomer() {
        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(getDriver());
        deleteCustomerPage.clickPageLink("Delete Customer");

        deleteCustomerPage.fillFormAndSubmit(this.customerId);
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Customer could not be deleted!!. First delete all accounts of this customer then delete the customer");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Customer")));

        this.customerId = "12532";
    }

    @Test(priority = 2)
    public void verifyThatACustomerCanBeDeleted() {
        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(getDriver());
        deleteCustomerPage.clickPageLink("Delete Customer");

        deleteCustomerPage.fillFormAndSubmit(this.customerId);
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
//        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Customer could not be Deleted.first delete all account of this customer and then delete the customer");
        getDriver().switchTo().alert().accept();
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Customer deleted Successfully");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Customer")));
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.demo.guru99.com/V4/manager/Managerhomepage.php");
    }

    @Test(priority = 3)
    public void verifyDeletedCustomerCannotBeEdited() {
        EditCustomerPage editCustomerPage = new EditCustomerPage((getDriver()));
        editCustomerPage.clickPageLink("Edit Customer");

        editCustomerPage.fillFormAndSubmit(this.customerId);
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Customer does not exist!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Customer")));
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.demo.guru99.com/V4/manager/EditCustomer.php");
    }

    @Test(priority = 4)
    public void verifySystemBehaviourWhenManagerDeletesANonExistingCustomerID() {
        DeleteCustomerPage deleteCustomerPage = new DeleteCustomerPage(getDriver());
        deleteCustomerPage.clickPageLink("Delete Customer");

        deleteCustomerPage.fillFormAndSubmit(this.customerId);
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Customer does not exist!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Customer")));
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.demo.guru99.com/V4/manager/DeleteCustomerInput.php");
    }
}
