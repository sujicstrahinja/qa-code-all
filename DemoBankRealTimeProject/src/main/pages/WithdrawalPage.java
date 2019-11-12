package main.pages;

import main.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawalPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoInput;
    @FindBy(name = "ammount")
    private WebElement amountInput;
    @FindBy(name = "desc")
    private WebElement descriptionInput;
    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public WithdrawalPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/WithdrawalInput.php");
    }

    public void fillAndSubmitForm(String accountNo, String amount, String description) {
        accountNoInput.sendKeys(accountNo);
        amountInput.sendKeys(amount);
        descriptionInput.sendKeys(description);

        submitButton.click();
    }

    public String getCurrentBalance() {
        WebElement balanceCell = driver.findElement(By.cssSelector("table.layout:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(23) > td:nth-child(2)"));
        return balanceCell.getText();
    }
}
