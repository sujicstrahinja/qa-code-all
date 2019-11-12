package main.pages;

import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundTransferPage extends BasePage {

    @FindBy(name = "payersaccount")
    private WebElement payersAccountNoInput;
    @FindBy(name = "payeeaccount")
    private WebElement payeesAccountNoInput;
    @FindBy(name = "ammount")
    private WebElement amountInput;
    @FindBy(name = "desc")
    private WebElement descriptionInput;
    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public FundTransferPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/FundTransInput.php");
    }

    public void fillAndSubmitForm(String payersAccountNo, String payeesAccountNo, String amount, String description) {
        payersAccountNoInput.sendKeys(payersAccountNo);
        payeesAccountNoInput.sendKeys(payeesAccountNo);
        amountInput.sendKeys(amount);
        descriptionInput.sendKeys(description);

        submitButton.click();
    }
}
