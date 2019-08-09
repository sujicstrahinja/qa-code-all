import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar2 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");

        driver.findElement(By.cssSelector("input[id='travel_date']")).click();

        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")) {
            driver.findElement(By.cssSelector(".datepicker-days .next")).click();
        }

        List<WebElement> days = driver.findElements(By.className("day"));

        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getText().equalsIgnoreCase("23")) {
                days.get(i).click();
                break;
            }
        }
    }
}
