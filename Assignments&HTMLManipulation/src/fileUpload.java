import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class fileUpload {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sujic\\Downloads\\SeleniumStuff\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.cssSelector(".js-fileapi-wrapper.g-btn.g-btn--primary.g-btn--choose")).click();
        Thread.sleep(3000);
//        Runtime.getRuntime().exec("C:\\Users\\sujic\\Documents\\check\\fileupload.exe");
        String projDir = "C:\\Users\\sujic\\Documents\\check\\";
        Runtime.getRuntime().exec(projDir+"\\fileupload.exe", null, new File(projDir));
//        File file = new File("C:\\Users\\sujic\\Documents\\check\\");
//        for(String fileNames : file.list()) System.out.println(fileNames);
    }
}
