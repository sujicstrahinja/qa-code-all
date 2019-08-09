import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasicTest extends Base {

    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) {
        initialize(browser);
    }

    @Test
    public void basicTest() {
        driver.get("http://demo.guru99.com/test/guru99home/");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Demo Guru99 Page"));
    }

    @AfterTest
    public void cleanup() {
        teardown();
    }
}
