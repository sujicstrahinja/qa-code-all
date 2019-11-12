package tests.manager;

import main.BaseTest;
import main.pages.CustomisedStatementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SM31 extends BaseTest {

    private String accountNo = "71644";

    @Test(enabled = false)
    public void verifyCustomizedStatment() {
        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        customisedStatementPage.clickPageLink("Customised Statement");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDate = dateFormat.format(calendar.getTime());
        String toDate = String.valueOf(java.time.LocalDate.now());
        String numberOfTransaction = "10";

        customisedStatementPage.fillFormAndSubmit(this.accountNo, fromDate, toDate, "", "");

        List<WebElement> transactionRows = getDriver().findElements(By.xpath("//tr//tr"));
        boolean isCustomisedStatementFound = false;
        for (int i = 1; i < transactionRows.size()-1; i++) {
            String actualAmount = transactionRows.get(i).findElement(By.xpath("//td[2]")).getText();
            String actualTransactionType = transactionRows.get(i).findElement(By.xpath("//td[3]")).getText();
            String actualDate =  transactionRows.get(i).findElement(By.xpath("//td[4]")).getText();
            String actualDescription = transactionRows.get(i).findElement(By.xpath("//td[5]")).getText();

            String amount = "5";
            String description = "cash";
            String dateOfTransaction = "2019-10-27";

            System.out.println(amount+"-to-"+actualAmount);
            System.out.println(description+"-to-"+actualDescription);
            System.out.println(dateOfTransaction+"-to-"+actualDate);

            if(actualAmount.equals(amount) &&
                    actualTransactionType.equals("w") &&
                    actualDate.equals(dateOfTransaction) &&
                    actualDescription.equals(description)) {
                isCustomisedStatementFound = true;
                break;
            }
        }

        Assert.assertTrue(isCustomisedStatementFound);
    }

    @Test
    public void verifyCustomizedStatementIsNotGeneratedWhenFromDateIsGreaterThanToDate() {
        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        customisedStatementPage.clickPageLink("Customised Statement");

        String currentDate = String.valueOf(java.time.LocalDate.now());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDate = dateFormat.format(calendar.getTime());
        String toDate = String.valueOf(java.time.LocalDate.now());
        customisedStatementPage.fillFormAndSubmit(this.accountNo, toDate, fromDate, "", "");

        WebDriverWait shortWait = new WebDriverWait(getDriver(), 5);
        shortWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(getDriver().switchTo().alert().getText(), "FromDate field should be lower than ToDate field!!");
        getDriver().switchTo().alert().dismiss();
        shortWait.until(ExpectedConditions.elementToBeClickable(By.name("accountno")));
    }

    @Test
    public void verifyCustomizedStatementIsGeneratedWhenFromDateIsLessThanToDate() {
        CustomisedStatementPage customisedStatementPage = new CustomisedStatementPage(getDriver());
        customisedStatementPage.clickPageLink("Customised Statement");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fromDate = dateFormat.format(calendar.getTime());
        String toDate = String.valueOf(java.time.LocalDate.now());
        String numberOfTransaction = "10";

        customisedStatementPage.fillFormAndSubmit(this.accountNo, "", "", "", "");
        Assert.assertEquals(getDriver().findElements(By.xpath("//p[text()[contains(., 'Transaction Details for Account No: "+this.accountNo+"')]]")).size(), 1);
    }
}
