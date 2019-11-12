package main.pages;

import main.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BalanceEnquiryPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoInput;
    @FindBy(name = "AccSubmit")
    private WebElement submitButton;
    @FindBy(name = "accountno")
    private WebElement Select;
    org.openqa.selenium.support.ui.Select accountNoDropdownInput = new Select(Select);

    public BalanceEnquiryPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/BalEnqInput.php");
    }

    public void fillFormAndSubmit(String accountNo) {
        accountNoInput.sendKeys(accountNo);

        submitButton.click();
    }

    public void selectAccount(String accountNo) {
        accountNoDropdownInput.selectByVisibleText(accountNo);

        submitButton.click();
    }

    public String getCurrentBalance() {
        WebElement balanceCell = driver.findElement(By.cssSelector("table.layout:nth-child(9) td:nth-child(1) table:nth-child(1) tbody:nth-child(1) tr:nth-child(16) > td:nth-child(2)"));
        return balanceCell.getText();
    }
}
