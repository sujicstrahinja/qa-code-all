package main.pages;

import main.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

//    private String url = "http://www.demo.guru99.com/V4/index.php";
    @FindBy(name = "uid")
    private WebElement userIdInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/index.php");
    }

    public void login(String username, String password) {
        userIdInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
