package tests.customer;

import main.BaseTest;
import main.pages.ChangePasswordPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SC1 extends BaseTest {

    @Test
    public void verifyChangeLoginPasswordAndLoginWhenOldPasswordIsIncorrect() {
        String oldPassword = "sifra2";
        String newPassword = "sifra1@";
        String confirmPassword = "sifra1@";

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(getDriver());
        changePasswordPage.clickPageLink("Changepassword");
        changePasswordPage.changePassword(oldPassword, newPassword, confirmPassword);
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Old Password is incorrect");
        changePasswordPage.cancelAlertAndWaitForPasswordInput();
        Assert.assertEquals(getDriver().findElements(By.xpath("//p[text()='Change Password']")).size(), 1);
    }
}
