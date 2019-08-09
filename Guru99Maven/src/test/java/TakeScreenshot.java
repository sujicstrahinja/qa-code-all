import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class TakeScreenshot extends Base {

    @BeforeTest
    public void initialize() {
        initialize("firefox");
    }

    @Test
    public void screenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        String savePath = System.getProperty("user.dir")+"\\Screenshots\\screenshot.png";
        File destFile= new File(savePath);

        FileUtils.copyFile(screenshotFile, destFile);
    }
}
