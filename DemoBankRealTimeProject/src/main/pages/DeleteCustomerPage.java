package main.pages;

import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage extends BasePage {

    @FindBy(name = "cusid")
    private WebElement customerIdInput;
    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public DeleteCustomerPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/DeleteCustomerInput.php");
    }

    public void fillFormAndSubmit(String customerId) {
        customerIdInput.sendKeys(customerId);

        submitButton.click();
    }
}
