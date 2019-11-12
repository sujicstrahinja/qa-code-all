package tests.manager;

import main.BaseTest;
import main.pages.ChangePasswordPage;
import main.pages.ManagerHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM1 extends BaseTest {

    @Test
    public void changeLoginPasswordAndLoginWhenOldPasswordIsIncorrect() {
        String oldPassword = "sifra1";
        String newPassword = "123456@";
        String confirmPassword = "123456@";

        ManagerHomePage managerHomePage = new ManagerHomePage(getDriver());

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(getDriver());
        changePasswordPage.clickPageLink("Change Password");
        changePasswordPage.changePassword(oldPassword, newPassword, confirmPassword);
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Old Password is incorrect");
        changePasswordPage.cancelAlertAndWaitForPasswordInput();
        Assert.assertEquals(getDriver().findElements(By.xpath("//p[text()='Change Password']")).size(), 1);
    }
}
