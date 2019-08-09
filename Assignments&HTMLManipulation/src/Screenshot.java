import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void main(String[] args) throws IOException {

        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\strahinja\\AppData\\Local\\Programs\\Opera\\60.0.3255.70\\opera.exe");
        System.setProperty("webdriver.opera.driver", "C:\\Users\\strahinja\\Downloads\\operadriver_win64\\operadriver.exe");
        WebDriver driver = new OperaDriver(options);

        driver.get("https://lonelyplanetimages.imgix.net/a/g/hi/t/b6cc5c258ca09474c5163178f01455e6-cuba.jpeg?sharp=10&vib=20&w=1200");

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\strahinja\\Pictures\\screenshot.png"));
    }
}
