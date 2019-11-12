package main.pages;

import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomisedStatementPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoInput;
    @FindBy(name = "fdate")
    private WebElement fromDateInput;
    @FindBy(name = "tdate")
    private WebElement toDateInput;
    @FindBy(name = "amountlowerlimit")
    private WebElement minimumTransactionValueInput;
    @FindBy(name = "numtransaction")
    private WebElement numberOfTransactionInput;
    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public CustomisedStatementPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/CustomisedStatementInput.php");
    }

    public void fillFormAndSubmit(String accountNo, String fromDate, String toDate, String amountlowerlimit, String numtransaction) {
        accountNoInput.sendKeys(accountNo);
        fromDateInput.sendKeys(fromDate);
        toDateInput.sendKeys(toDate);
        minimumTransactionValueInput.sendKeys(amountlowerlimit);
        numberOfTransactionInput.sendKeys(numtransaction);

        submitButton.click();
    }
}
