package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriver driver = null;
    String url = "http://www.qaclickacademy.com/";
    @FindBy(css = "a[href='http://qaclickacademy.usefedora.com/sign_in']")
    WebElement loginLink;
    @FindBy(css = " ul[class='nav navbar-nav navbar-right']")
    WebElement navigationUl;
    @FindBy(xpath = "//button[text()='NO THANKS']")
    List<WebElement> noThanksLink;

    public void goToPage() {
        driver.get(url);
    }

    public void closePopUp() {
        if (noThanksLink.size() > 0) {
            noThanksLink.get(1).click();
        }
    }

    public void clickLoginLink() {
        closePopUp();
        loginLink.click();
    }

    public WebElement getNavigationUl() {
        return navigationUl;
    }
}
