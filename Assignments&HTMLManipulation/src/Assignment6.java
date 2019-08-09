import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");

        WebElement checkboxToSelect = driver.findElement(By.cssSelector("input[value='option1']"));
        checkboxToSelect.click();

        String checkboxLabel = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/..")).getText();

        System.out.println(checkboxLabel);

        Select dropdownExample = new Select(driver.findElement(By.cssSelector("select[id='dropdown-class-example']")));
        dropdownExample.selectByValue(checkboxToSelect.getAttribute("value"));

        driver.findElement(By.cssSelector("input[id='name']")).sendKeys(checkboxLabel);
        driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
        if (driver.switchTo().alert().getText().contains(checkboxLabel)) {
            System.out.println("checkbox label contains alert text");
        }
    }
}
