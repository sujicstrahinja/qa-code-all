import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class MaxWindowPLUSDeleteCookies {

    public static void main(String[] args) {

        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\strahinja\\AppData\\Local\\Programs\\Opera\\60.0.3255.70\\opera.exe");
        System.setProperty("webdriver.opera.driver", "C:\\Users\\strahinja\\Downloads\\operadriver_win64\\operadriver.exe");
        WebDriver driver = new OperaDriver(options);

        driver.get("...");
    }
}
