package main.pages;

import main.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditCustomerPage extends BasePage {

    @FindBy(name = "cusid")
    private WebElement customerIdInput;
    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public EditCustomerPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/EditCustomer.php");
    }

    public void fillFormAndSubmit(String customerId) {
        customerIdInput.sendKeys(customerId);

        submitButton.click();
    }

    public void verifyRetrievedData(String expectedCustomerName, String expectedGender, String expectedDateOfBirth, String expectedAddress, String expectedCity, String expectedState, String expectedPin, String expectedMobileNumber, String expectedEmail) {
        WebElement customerNameInput = driver.findElement(By.name("name"));
        WebElement genderInput = driver.findElement(By.name("gender"));
        WebElement dateofbirthInput = driver.findElement(By.name("dob"));
        WebElement addressInput = driver.findElement(By.name("addr"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement stateInput = driver.findElement(By.name("state"));
        WebElement pinInput = driver.findElement(By.name("pinno"));
        WebElement mobileNumberInput = driver.findElement(By.name("telephoneno"));
        WebElement emailInput = driver.findElement(By.name("emailid"));
    }

    public String getInputValueByName(String inputName) {
        return driver.findElement(By.name(inputName)).getAttribute("value");
    }
}
