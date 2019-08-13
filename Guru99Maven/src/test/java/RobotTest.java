
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotTest extends Base {

    public static void main(String[] args) throws AWTException {

        initialize("firefox");

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.cssSelector("a[href='download/uploadImage.png']")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_UP);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
    }
}
