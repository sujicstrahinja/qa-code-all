package tests.manager;

import main.BaseTest;
import main.pages.EditCustomerPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SM23 extends BaseTest {

    @Test
    public void verifyEditCustomer() {
        EditCustomerPage editCustomerPage = new EditCustomerPage(getDriver());
        editCustomerPage.clickPageLink("Edit Customer");

        String customerId = "10270";

        String expectedCustomerName = "Virendra";
        String expectedGender = "male";
        String expectedDateOfBirth = "2013-11-04";
        String expectedAddress = "Jamnagar";
        String expectedCity = "Jamnagar";
        String expectedState = "Gujarat";
        String expectedPin = "567321";
        String expectedMobileNumber = "8000439024";
        String expectedEmail = "Virendra124@gmail.com";

        editCustomerPage.fillFormAndSubmit(customerId);

        Assert.assertEquals(editCustomerPage.getInputValueByName("name"), expectedCustomerName);
        Assert.assertEquals(editCustomerPage.getInputValueByName("gender"), expectedGender);
        Assert.assertEquals(editCustomerPage.getInputValueByName("dob"), expectedDateOfBirth);
        Assert.assertEquals(editCustomerPage.getInputValueByName("addr"), expectedAddress);
        Assert.assertEquals(editCustomerPage.getInputValueByName("city"), expectedCity);
        Assert.assertEquals(editCustomerPage.getInputValueByName("state"), expectedState);
        Assert.assertEquals(editCustomerPage.getInputValueByName("pinno"), expectedPin);
        Assert.assertEquals(editCustomerPage.getInputValueByName("telephoneno"), expectedMobileNumber);
        Assert.assertEquals(editCustomerPage.getInputValueByName("emailid"), expectedEmail);
    }
}