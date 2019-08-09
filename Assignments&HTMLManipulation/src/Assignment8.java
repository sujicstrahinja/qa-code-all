import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Assignment8 {

    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver", "C:\\Users\\strahinja\\Downloads\\operadriver_win64\\operadriver.exe");
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\strahinja\\AppData\\Local\\Programs\\Opera\\60.0.3255.70\\opera.exe");
        WebDriver driver = new OperaDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("http://www.qaclickacademy.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='sumome-react-wysiwyg-move-handle']")));
        driver.findElement(By.xpath("//div[@class='sumome-react-wysiwyg-move-handle']/div/div[2]")).click();
        driver.findElement(By.cssSelector("a[href='practice.php']")).click();

        WebElement table = driver.findElement(By.cssSelector("table[id='product']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int rowCount = rows.size();
        int columnCount = rows.get(1).findElements(By.tagName("td")).size();
        List<WebElement> secondRowColumns = rows.get(2).findElements(By.tagName("td"));
        String instructor = secondRowColumns.get(0).getText();
        String course = secondRowColumns.get(1).getText();
        String price = secondRowColumns.get(2).getText();

        System.out.println("Number of rows: " + rowCount);
        System.out.println("Number of columns: " + columnCount);
        System.out.println("Instructor: " + instructor + ", course: " + course + ", price: " +price);
    }
}
