import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.cleartrip.com/");
        Select adultsDropdown = new Select(driver.findElement(By.cssSelector("select#Adults")));
        Select childrenDropdown = new Select(driver.findElement(By.cssSelector("select#Childrens")));
        Select infantsDropdown = new Select(driver.findElement(By.cssSelector("select#Infants")));

        adultsDropdown.selectByValue("5");
        childrenDropdown.selectByValue("4");
        infantsDropdown.selectByValue("1");
        driver.findElement(By.cssSelector("input[id='DepartDate']")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        driver.findElement(By.cssSelector("a[id='MoreOptionsLink']")).click();
        Select classOfTravelDropdown = new Select(driver.findElement(By.cssSelector("select#Class")));
        classOfTravelDropdown.selectByValue("Premium Economy");
        driver.findElement(By.cssSelector("input#AirlineAutocomplete")).sendKeys("djoka");
        driver.findElement(By.cssSelector("input#SearchBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("div#homeErrorMessage")).getText());

        driver.close();
    }
}
