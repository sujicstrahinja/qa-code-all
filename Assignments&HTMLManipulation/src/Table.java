import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Table {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\strahinja\\Downloads\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22488/dc-vs-rr-53rd-match-indian-premier-league-2019");

        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        List<WebElement> rows = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
        int sum = 0;
        int i;
        for (i = 0; i < rows.size()-3; i++) {
            String rowValue = rows.get(i).findElement(By.cssSelector("div[class='cb-col cb-col-8 text-right text-bold']")).getText();
            sum += Integer.parseInt(rowValue);
        }

        String extrasValue = rows.get(i).findElement(By.cssSelector("div[class='cb-col cb-col-8 text-bold cb-text-black text-right']")).getText();
        int extras = Integer.parseInt(extrasValue);

        sum += extras;
        i++;

        String totalValue = rows.get(i).findElement(By.cssSelector("div[class='cb-col cb-col-8 text-bold text-black text-right']")).getText();
        int total = Integer.parseInt(totalValue);

        if (sum == total) {
            System.out.println("sum and total are the same");
        } else {
            System.out.println("sum and total are not the same");
        }
    }
}
