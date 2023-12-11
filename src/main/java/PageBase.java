import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
    protected WebDriver driver;
   protected WebElement element;
    public PageBase(WebDriver driver)
    {
        this.driver=driver;
    }

    public static void clicking (WebElement element)
    {
        element.click();
    }

    public static void entering (WebElement element, String text)
    {
        element.sendKeys(text);
    }

    public static void dropDown (WebElement element, String value)
    {
        Select select =new Select(element);
        select.selectByValue(value);
    }

}
