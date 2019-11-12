package main.pages;

import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCustomerPage extends BasePage {

    @FindBy(name = "name")
    private WebElement customerNameInput;
    @FindBy(name = "rad1")
    private WebElement genderInput;
    @FindBy(name = "dob")
    private WebElement dateofbirthInput;
    @FindBy(name = "addr")
    private WebElement addressInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(name = "state")
    private WebElement stateInput;
    @FindBy(name = "pinno")
    private WebElement pinInput;
    @FindBy(name = "telephoneno")
    private WebElement mobileNumberInput;
    @FindBy(name = "emailid")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public AddNewCustomerPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/addcustomerpage.php");
    }

    public void fillAndSubmitAddNewCustomerForm(String customerName, String gender, String dateofbirth, String address, String city, String state, String pin, String mobileNumber, String email, String password) {
        customerNameInput.sendKeys(customerName);
        genderInput.sendKeys(gender);
        dateofbirthInput.sendKeys(dateofbirth);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        stateInput.sendKeys(state);
        pinInput.sendKeys(pin);
        mobileNumberInput.sendKeys(mobileNumber);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        submitButton.click();
    }
}
