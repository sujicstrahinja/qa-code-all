import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment5 {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.linkText("Nested Frames")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("html / frameset / frame[1]")));
        driver.switchTo().frame((driver.findElement(By.xpath("html / frameset / frame[2]"))));
//        driver.switchTo().frame("frame-top");
//        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());

        driver.switchTo().defaultContent();
    }
}
