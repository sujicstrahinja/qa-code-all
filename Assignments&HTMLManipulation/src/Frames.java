import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Frames {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://jqueryui.com/droppable/");

//        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        driver.findElement(By.cssSelector("div[id='draggable']")).click();

        Actions builder = new Actions(driver);

        WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
        WebElement target = driver.findElement(By.cssSelector("div[id='droppable']"));

        Action dragAndDrop = builder.dragAndDrop(source, target).build();

        dragAndDrop.perform();
        driver.switchTo().defaultContent();
    }
}
