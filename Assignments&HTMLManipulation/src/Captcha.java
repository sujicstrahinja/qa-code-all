import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Captcha {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spotify.com/ca-en/signup/");
        By byOfCaptchaCheckbox = By.xpath(".//*[@id='recaptcha-anchor']");
        int frameNumber = findFrameNumber(driver, byOfCaptchaCheckbox);
        driver.switchTo().frame(frameNumber);
        driver.findElement(byOfCaptchaCheckbox).click();

        By byOfVerifyButton = By.xpath(".//*[@id='ID_ZA_VERIFY_BUTTON_']");
        frameNumber = findFrameNumber(driver, byOfCaptchaCheckbox);
        driver.switchTo().frame(frameNumber);
        driver.findElement(byOfVerifyButton).click();

//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[width='304']")));
//        driver.findElement(By.cssSelector("div[class='rc-anchor rc-anchor-normal rc-anchor-light']")).click();
//
//        driver.switchTo().defaultContent();
//        WebDriverWait wait = new WebDriverWait(driver, 3);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("iframe[title='recaptcha challenge']")));
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='recaptcha challenge']")));
//        Thread.sleep(1000L);
//        driver.findElement(By.cssSelector("[class='rc-button-default'] [class='goog-inline-block']")).click();
    }

    public static int findFrameNumber(WebDriver driver, By by) {
        int frameNumber;
        int framesOnPage = driver.findElements(By.tagName("iframe")).size();

        for (frameNumber = 1; frameNumber < framesOnPage; frameNumber++) {
            driver.switchTo().frame(frameNumber);
            if (driver.findElements(by).size() > 0) {
                break;
            } else {
                System.out.println("Not found in frame " + frameNumber);
            }
        }

        driver.switchTo().defaultContent();
        return frameNumber;
    }
}
