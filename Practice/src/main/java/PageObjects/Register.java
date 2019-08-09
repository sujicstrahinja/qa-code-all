package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Register extends Base {

    public Register(WebDriver driver) {
        pageURL = "http://demo.guru99.com/test/newtours/register.php";
        pageTitle = "Register: Mercury Tours";
        this.driver = initializeDriver();
        PageFactory.initElements(driver, this);
    }
}
