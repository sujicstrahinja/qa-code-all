package main.pages;

import main.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordPage extends BasePage {

    @FindBy(name = "oldpassword")
    private WebElement oldPasswordInput;
    @FindBy(name = "newpassword")
    private WebElement newPasswordInput;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public ChangePasswordPage(WebDriver driver) {
        super(driver, "http://www.demo.guru99.com/V4/manager/PasswordInput.php");
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword) {
        oldPasswordInput.sendKeys(oldPassword);
        newPasswordInput.sendKeys(newPassword);
        confirmPasswordInput.sendKeys(confirmPassword);
        submitButton.click();
    }

    public void cancelAlertAndWaitForPasswordInput() {
        driver.switchTo().alert().accept();
        waitForElementToAppear(By.name("oldpassword"));
    }
}
