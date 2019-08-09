import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

    public static void main(String[] args) {
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\strahinja\\AppData\\Local\\Programs\\Opera\\60.0.3255.70\\opera.exe");
        System.setProperty("webdriver.opera.driver", "C:\\Users\\strahinja\\Downloads\\operadriver_win64\\operadriver.exe");
        WebDriver driver = new OperaDriver(options);

        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();

        WebDriverWait shortWait = new WebDriverWait(driver, 3);
        shortWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#modal")));
        System.out.println(driver.findElement(By.cssSelector("div#results")).getText());
    }
}
