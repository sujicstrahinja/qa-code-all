package tests.customer;

import main.BaseTest;
import main.pages.MiniStatementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SC7 extends BaseTest {

    @Test
    public void verifyTransferDetailsAppearOnTheMiniStatement() {
        MiniStatementPage miniStatementPage = new MiniStatementPage(getDriver());
        miniStatementPage.clickPageLink("Mini Statement");

        String accountNo = "71949";

        miniStatementPage.fillFormAndSubmit(accountNo);
        List<WebElement> transactionRows = getDriver().findElements(By.xpath("//tr//tr"));
        boolean isMiniStatementFound = false;
        for (int i = 1; i < transactionRows.size()-1; i++) {
            String actualAmount = transactionRows.get(i).findElement(By.xpath("//td[2]")).getText();
            String actualTransactionType = transactionRows.get(i).findElement(By.xpath("//td[3]")).getText();
            String actualDate =  transactionRows.get(i).findElement(By.xpath("//td[4]")).getText();
            String actualDescription = transactionRows.get(i).findElement(By.xpath("//td[5]")).getText();

            String amount = "500";
            String description = "Initial Deposit";
            String dateOfTransaction = "2019-11-02";

//            System.out.println(amount+"-to-"+actualAmount);
//            System.out.println(description+"-to-"+actualDescription);
//            System.out.println(dateOfTransaction+"-to-"+actualDate);

            if(actualAmount.equals(amount) &&
                    actualTransactionType.equals("D") &&
                    actualDate.equals(dateOfTransaction) &&
                    actualDescription.equals(description)) {
                isMiniStatementFound = true;
                break;
            }
        }

        Assert.assertTrue(isMiniStatementFound);
    }
}
