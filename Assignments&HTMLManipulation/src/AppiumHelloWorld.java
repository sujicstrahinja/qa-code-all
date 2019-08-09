//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidElement;
//import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumHelloWorld {

    public static void main(String[] args) throws MalformedURLException {

        File src = new File("src");
        File appPath = new File(src, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AppiumEmulatorTest");
//        capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
//
//        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
