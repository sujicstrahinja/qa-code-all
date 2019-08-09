package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Guru99Home extends BasePage {

    @FindBy(xpath = "//td[contains(text(), 'Manger Id : ')]")
    private List<WebElement> managerId;

    public Guru99Home(WebDriver driver) {
        this.driver = driver;
        this.url = "http://www.demo.guru99.com/V4/manager/Managerhomepage.php";
        PageFactory.initElements(driver, this);
    }

    public boolean doesManagerIdExist() {
        boolean doesManagerIdExist = true;
        if (managerId.size() == 0) { doesManagerIdExist = false; }
        return doesManagerIdExist;
    }
}
