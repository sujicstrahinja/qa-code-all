package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Guru99Login extends BasePage {

    @FindBy(css = "h2[class='barone']")
    private List<WebElement> guruHeader;
    @FindBy(name = "uid")
    private WebElement userIdInputField;
    @FindBy(name = "password")
    private WebElement passwordInputField;
    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public Guru99Login(WebDriver driver) {
        this.driver = driver;
        this.url = "http://www.demo.guru99.com/V4/";
        PageFactory.initElements(driver, this);
    }

    public boolean doesGuru99BankHeaderExist() {
        boolean doesHeaderExist = true;
        if (guruHeader.size() == 0) { doesHeaderExist = false; }
        return doesHeaderExist;
    }

    private void setUserId(String userId) {
        this.userIdInputField.sendKeys(userId);
    }

    private void setPassword(String password) {
        this.passwordInputField.sendKeys(password);
    }

    private void clickLogin() {
        loginButton.click();
    }

    public void loginToGuru99(String userId, String password) {
        this.setUserId(userId);
        this.setPassword(password);
        this.clickLogin();
    }
}
