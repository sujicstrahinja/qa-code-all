import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Guru99VerifyLogin extends Base {

    private String baseUrl  = "http://www.demo.guru99.com/V4/";

    @Test(groups = { "bonding", "strong_ties" })
    public void tc01LaunchURL() {
        initialize("firefox");
        driver.get(baseUrl);
    }

    @Test(groups = { "bonding" })
    public void tc02VerifyLaunchPage() {
        int headingCount = driver.findElements(By.cssSelector("h2[class='barone']")).size();
        boolean doesHeadingExist = false;
        if (headingCount > 0) { doesHeadingExist = true; }
        Assert.assertTrue(doesHeadingExist, "Heading not found");
    }

    @Test(groups = { "bonding", "strong_ties" })
    public void tc03EnterCredentials() {
        String userId = "mngr208309";
        String password = "rYvehuv";
        WebElement userIdInput = driver.findElement(By.name("uid"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("btnLogin"));

        userIdInput.sendKeys(userId);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Test(groups = { "strong_ties" })
    public void tc04VerifyLoggedInPage() {
        int managerIdCount = driver.findElements(By.cssSelector("td[style='color: green']")).size();
        boolean doesManagerIdExist = false;
        if (managerIdCount > 0) doesManagerIdExist = true;
        Assert.assertTrue(doesManagerIdExist);
    }

    @Test(groups = { "bonding" })
    public void tc05VerifyHyperlinks() {
        List<WebElement> links = driver.findElements(By.cssSelector(".menusubnav a"));
        String managerUrl = "http://www.demo.guru99.com/V4/manager/";
        String firstLinkUrl = managerUrl+"Managerhomepage.php";
        String middleLinkUrl = managerUrl+"deleteAccountInput.php";
        String lastLinkUrl = managerUrl+"Logout.php";

        Assert.assertEquals(firstLinkUrl, links.get(0).getAttribute("href"));
        Assert.assertEquals(middleLinkUrl, links.get(6).getAttribute("href"));
        Assert.assertEquals(lastLinkUrl, links.get(14).getAttribute("href"));
    }

    @AfterTest
    public void cleanUp() {
        teardown();
    }
}
