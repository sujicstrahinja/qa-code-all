package tests.customer;

import main.BaseTest;
import main.pages.ChangePasswordPage;
import main.pages.LoginPage;
import main.pages.ManagerHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SC2 extends BaseTest {

    private String newPassword = "";

    @Test(priority = 0)
    public void verifyChangePasswordAndLogInAfterPasswordSsChangedpageIsRedirectedToLogInScreen() {
        String oldPassword = "sifra1";
        String newPassword = "sifra1@";
        String confirmPassword = "sifra1@";

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(getDriver());
        changePasswordPage.clickPageLink("Changepassword");
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

        String username = "23924";

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, this.newPassword);

        int customerWelcomeTextCount = getDriver().findElements(By.tagName("//marquee")).size();
        Assert.assertEquals(customerWelcomeTextCount, 1);
    }
}
