package tests.manager;

import main.BaseTest;
import main.pages.ChangePasswordPage;
import main.pages.LoginPage;
import main.pages.ManagerHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM2 extends BaseTest {

    private String username = "";
    private String newPassword = "";

//    WEBSITE DOES NOT WORK
    @Test(priority = 0)
    public void changeLoginPasswordAndLoginWhenOldPasswordIsCorrect() {
        String oldPassword = "AbUzuhA";
        String newPassword = "123456@";
        String confirmPassword = "123456@";

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(getDriver());
        changePasswordPage.clickPageLink("Change Password");
        changePasswordPage.changePassword(oldPassword, newPassword, confirmPassword);
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Password is changed");
        changePasswordPage.cancelAlertAndWaitForPasswordInput();
        this.newPassword = newPassword;
    }

    @Test(priority = 1)
    public void changeLoginPasswordAndLoginVerifyLogin() {
        ManagerHomePage managerHomePage = new ManagerHomePage(getDriver());
        managerHomePage.clickPageLink("Log Out");
        getDriver().switchTo().alert().accept();

        String username = "mngr230255";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, this.newPassword);

        int managerIdTextCount = getDriver().findElements(By.xpath("//td[text()='Manger Id : " + username + "']")).size();
        Assert.assertEquals(managerIdTextCount, 1);
    }
}
