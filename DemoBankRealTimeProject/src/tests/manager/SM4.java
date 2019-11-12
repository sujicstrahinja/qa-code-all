package tests.manager;

import main.BaseTest;
import main.pages.AddNewAccountPage;
import main.pages.AddNewCustomerPage;
import main.pages.ManagerHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM4 extends BaseTest {

    private String customerId = "";
//  66770/ 12146
    @Test(priority = 0)
    public void verifyAddingNewCustomerRedirectsToDetailsOfAddedCustomer() {
        String customerId = "67902";
        String customerName = "Virendra";
        String gender = "male";
        String birthdate = "2013-11-04";
        String address = "Jamnagar";
        String city = "Jamnagar";
        String state = "Gujarat";
        String pin = "567321";
        String mobileNo = "8000439024";
        String email = "Virendra125@gmail.com";
        String password = "sifra1@";

        AddNewCustomerPage addNewCustomerPage = new AddNewCustomerPage(getDriver());
        addNewCustomerPage.clickPageLink("New Customer");
        addNewCustomerPage.fillAndSubmitAddNewCustomerForm(customerName, gender, birthdate, address, city, state, pin, mobileNo, email, password);
        Assert.assertEquals(getDriver().findElements(By.xpath("//p[text()='Customer Registered Successfully!!!']")).size(), 1);
        this.customerId = getDriver().findElement(By.cssSelector("table.layout:nth-child(8) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(2)")).getText();
    }

    @Test(priority = 1)
    public void verifyAddingNewAccountToNewlyCreatedCustomer() {
        String accountType = "Savings";
        String initialDeposit = "500";
        ManagerHomePage managerHomePage = new ManagerHomePage(getDriver());
        managerHomePage.clickPageLink("New Account");
        AddNewAccountPage addNewAccountPage = new AddNewAccountPage(getDriver());
//        addNewAccountPage.clickPageLink("New Account");
        addNewAccountPage.fillAndSubmitAddNewAccountForm(this.customerId, accountType, initialDeposit);

        Assert.assertEquals(getDriver().findElements(By.xpath("//p[text()='Account Generated Successfully!!!']")).size(), 1);
    }
}
