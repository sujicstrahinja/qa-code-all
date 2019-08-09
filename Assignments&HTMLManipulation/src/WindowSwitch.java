import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowSwitch {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.ie.driver", "C:\\Users\\strahinja\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");

        WebDriver driver = new InternetExplorerDriver();

        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.findElement(By.linkText("Приватност")).click();

        Set<String> tabIds = driver.getWindowHandles();
        Iterator<String> currentlyPointedId = tabIds.iterator();
        String rootTabId = currentlyPointedId .next();
        String openedTabId = currentlyPointedId .next();
        driver.switchTo().window(openedTabId);

        System.out.println(driver.getTitle());
    }
}
