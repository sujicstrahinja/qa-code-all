import org.testng.annotations.Test;

public class EdgeTest extends Base{

    @Test
    public void openChrome() {
        initialize("edge");

        driver.get("https://www.google.com");
    }
}
