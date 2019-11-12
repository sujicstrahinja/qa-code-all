package main.pages;

import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoInput;
    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public DeleteAccountPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/DeleteCustomerInput.php");
    }

    public void fillFormAndSubmit(String accountNo) {
        accountNoInput.sendKeys(accountNo);

        submitButton.click();
    }
}
