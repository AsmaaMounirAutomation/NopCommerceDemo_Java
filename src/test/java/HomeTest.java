import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeTest extends TestBase{
    HomePage homePage;

    @Test (priority = 1)
    public void HomePageTest ()
    {
        homePage=new HomePage(driver);
        homePage.clickOnRegister();
        driver.navigate().back();

    }

    @Test (priority = 2)
    public void checkTitle ()
    {
        homePage=new HomePage(driver);
       String actualTitle=homePage.checkTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals( actualTitle,"nopCommerce demo store","true");

    }
    @Test (priority = 3)
    public void checkLogoIsDisplayed()
    {
        homePage=new HomePage(driver);
        WebElement logo = homePage.checkLogoIsDisplayed();
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test (priority = 4)
    public void verifySearchFunctionality()
    {
        homePage=new HomePage(driver);
       homePage.verifySearchFunctionality("book");
      List<WebElement>  searchResults = driver.findElements(By.xpath("//div[@class='product-item']")); //note here findelementSSSS
       Assert.assertTrue(searchResults.size()>0);

    }
    @Test(priority = 5)
    public void verifyFooterLinks()
    {
        homePage=new HomePage(driver);
      Assert.assertTrue( homePage.verifyFooterLinks() >=3);
    }




}
