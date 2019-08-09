import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoggingDemo extends Base {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        initialize("firefox");
        Logger log = LogManager.getLogger("devpinoyLogger");

        driver.get("http://healthunify.com/bmicalculator/");
        log.debug("opening webiste");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.debug("entring weight");
        driver.findElement(By.name("wg")).sendKeys("87");
        log.debug("selecting kilograms");
        driver.findElement(By.name("opt1")).sendKeys("kilograms");
        log.debug("selecting height in feet");
        driver.findElement(By.name("opt2")).sendKeys("5");
        log.debug("selecting height in inchs");
        driver.findElement(By.name("opt3")).sendKeys("10");
        log.debug("Clicking on calculate");
        driver.findElement(By.name("cc")).click();

        log.debug("Getting SIUnit value");
        String SIUnit = driver.findElement(By.name("si")).getAttribute("value");
        log.debug("Getting USUnit value");
        String USUnit = driver.findElement(By.name("us")).getAttribute("value");
        log.debug("Getting UKUnit value");
        String UKUnit = driver.findElement(By.name("uk")).getAttribute("value");
        log.debug("Getting overall description");
        String note = driver.findElement(By.name("desc")).getAttribute("value");

        System.out.println("SIUnit = " + SIUnit);
        System.out.println("USUnit = " + USUnit);
        System.out.println("UKUnit = " + UKUnit);
        System.out.println("note = " + note);
        driver.quit();
    }
}
