package main.pages;

import main.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerHomePage extends BasePage {

//    @FindBy(linkText = "Manager")
//    private WebElement managerLink;
//    @FindBy(linkText = "New Customer")
//    private WebElement newCustomerLink;
//    @FindBy(linkText = "Edit Customer")
//    private WebElement editCustomerLink;
//    @FindBy(linkText = "Delete Customer")
//    private WebElement deleteCustomerLink;
//    @FindBy(linkText = "New Account")
//    private WebElement newAccountLink;
//    @FindBy(linkText = "Edit Account")
//    private WebElement editAccountLink;
//    @FindBy(linkText = "Delete Account")
//    private WebElement deleteAccountLink;
//    @FindBy(linkText = "Deposit")
//    private WebElement depositLink;
//    @FindBy(linkText = "Withdrawal")
//    private WebElement withdrawalLink;
//    @FindBy(linkText = "Fund Transfer")
//    private WebElement fundTransferLink;
//    @FindBy(linkText = "Change Password")
//    private WebElement changePasswordLink;
//    @FindBy(linkText = "Balance Enquiry")
//    private WebElement balanceEnquiryLink;
//    @FindBy(linkText = "Mini Statement")
//    private WebElement miniStatementLink;
//    @FindBy(linkText = "Customised Statement")
//    private WebElement customisedStatementLink;
//    @FindBy(linkText = "Log out")
//    private WebElement logOutLink;

    public ManagerHomePage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/Managerhomepage.php");
    }
}
