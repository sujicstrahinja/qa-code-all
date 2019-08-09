package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Support extends Base {

    public Support(WebDriver driver) {
        pageURL = "http://demo.guru99.com/test/newtours/support.php";
        pageTitle = "Under Construction: Mercury Tours";
        this.driver = initializeDriver();
        PageFactory.initElements(driver, this);
    }
}
