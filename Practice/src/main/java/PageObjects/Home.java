package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home extends Base {

    public Home(WebDriver driver) {
        pageURL = "http://demo.guru99.com/test/newtours/";
        pageTitle = "Welcome: Mercury Tours";
        this.driver = initializeDriver();
        PageFactory.initElements(driver, this);
    }

//    public void goToPage() {
//        driver.get(pageURL);
//    }
//
//    public String getPageTitle() {
//        return pageTitle;
//    }
}
