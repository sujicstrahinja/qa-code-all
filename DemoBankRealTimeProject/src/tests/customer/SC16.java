package tests.customer;

import main.BaseTest;
import main.pages.CustomisedStatementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SC16 extends BaseTest {

    @Test
    public void verifyACustomerCanSeeCustomizedStatementOfOnlyHisAccount() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        js.executeScript("window.scrollBy(0,1000)");
        customisedStatementPage.clickPageLink("Customised Statement");

        String accountNo = "71645";
        String currentDate = String.valueOf(java.time.LocalDate.now());
        String numberOfTransactions = "10";

        customisedStatementPage.fillFormAndSubmit(accountNo, "", currentDate, "", numberOfTransactions);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "You are not authorize to generate statement of this Account!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Customised Statement")));
    }

    @Test
    public void verifySystemBehaviorWhenWrongAccountNumberIsEnteredInTheCustomizedStatement() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        js.executeScript("window.scrollBy(0,1000)");
        customisedStatementPage.clickPageLink("Customised Statement");

        String accountNo = "7164571645";
        String currentDate = String.valueOf(java.time.LocalDate.now());
        String numberOfTransactions = "10";

        customisedStatementPage.fillFormAndSubmit(accountNo, "", currentDate, "", numberOfTransactions);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "Account does not exist");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Customised Statement")));
    }

    @Test
    public void verifyCustomizedStatementIsNotGeneratedWhenFromDateIsGreaterThanToDate() {
        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        js.executeScript("window.scrollBy(0,1000)");
        customisedStatementPage.clickPageLink("Customised Statement");

        String accountNo = "72182";
        String currentDate = String.valueOf(java.time.LocalDate.now());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDate = dateFormat.format(calendar.getTime());
        String toDate = String.valueOf(java.time.LocalDate.now());
        customisedStatementPage.fillFormAndSubmit(accountNo, toDate, fromDate, "", "");

        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "FromDate field should be lower than ToDate field!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("accountno")));
    }
}
