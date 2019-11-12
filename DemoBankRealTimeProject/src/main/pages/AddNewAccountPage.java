package main.pages;

import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddNewAccountPage extends BasePage {

    @FindBy(name = "cusid")
    private WebElement customerIdInput;
    @FindBy(name = "selaccount")
    private WebElement Select;
    Select accountTypeInput = new Select(Select);
    @FindBy(name = "inideposit")
    private WebElement initialDepositInput;
    @FindBy(name = "button2")
    private WebElement submitButton;

    public AddNewAccountPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/addAccount.php");
    }

    public void fillAndSubmitAddNewAccountForm(String customerId, String accountType, String initialDeposit) {
        customerIdInput.sendKeys(customerId);
        accountTypeInput.selectByVisibleText(accountType);
        initialDepositInput.sendKeys(initialDeposit);

        submitButton.click();
    }
}
