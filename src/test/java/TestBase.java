import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    public void setup()
    {
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

   /* @AfterTest
    public void quit()
    {
        driver.quit();
    }*/

}
