import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qaclickacademy.com/interview.php");
        driver.findElement(By.xpath("//li[@id='tablist1-tab1']")).click();
        for (int i = 1; i < 4; i++) {
            driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li["+i+"]")).click();
        }
    }

    public static void testGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }

    public static void testFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\strahinja\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://login.salesforce.com/?locale=eu");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("email@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sifra1");
//        driver.findElement(By.xpath("//input[@id='Login']")).click();

        doesErrorExist(driver);
    }

    public static void doesErrorExist(WebDriver driver) {

        if (driver.getPageSource().contains("Please check your username and password. If you still can't log in, contact your Salesforce administrator.")) {
            System.out.println("Login clicked");
        } else {
            System.out.println("Login not clicked");
        }
    }
}
