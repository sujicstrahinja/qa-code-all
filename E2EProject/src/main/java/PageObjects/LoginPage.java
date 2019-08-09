package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver = null;
    String url = "https://sso.teachable.com/secure/9521/users/sign_in?clean_login=true&reset_purchase_session=1";
    @FindBy(css = "input[id='user_email']")
    WebElement emailAddressInputField;
    @FindBy(css = "input[id='user_password']")
    WebElement passwordInputField;
    @FindBy(css = "input[type='submit']")
    WebElement logInButton;
    @FindBy(css = "input[id='user_email']")
    List<WebElement> userEmailFieldCount;

    public void goToPage() {
        driver.get(url);
    }

    public void setEmailAddress(String text) {
        emailAddressInputField.sendKeys(text);
    }

    public void setPassword(String text) {
        passwordInputField.sendKeys(text);
    }

    public void doLogIn() {
        logInButton.click();
    }

    public boolean doesEmailFieldExist() {
        if (userEmailFieldCount.size() > 0) return true;
        return false;
    }
}
