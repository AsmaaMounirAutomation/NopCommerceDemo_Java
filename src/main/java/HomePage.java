import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By registerButton =By.className("ico-register");
    By loginButton =By.className("ico-login");

    WebElement logo =driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
    WebElement searchBox= driver.findElement(By.xpath("//input[@type='text']"));
    WebElement searchTool = driver.findElement(By.xpath("//button[@type='submit']"));
    List<WebElement> footerLinks = driver.findElements(By.xpath("//a[@rel='noopener noreferrer']"));


    public RegisterPage clickOnRegister ( )
    {
        WebElement registerElement = driver.findElement(registerButton);
        clicking(registerElement);
        return new RegisterPage(driver); // l satr da 3shan yrg3ly l register page
    }

    public LoginPage clickOnLogin ( )
    {
        WebElement loginElement = driver.findElement(loginButton);
        clicking(loginElement);
        return new LoginPage(driver);
    }

    public String checkTitle ()
    {
        String title= driver.getTitle();
        return title;
    }

    public WebElement checkLogoIsDisplayed ()
    {
       return logo;
    }

    public void verifySearchFunctionality(String text)
    {
        searchBox.sendKeys(text);
        searchTool.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.navigate().back();
    }

    public int verifyFooterLinks()
    {
        int footerLinksNo=footerLinks.size();
        return footerLinksNo;

    }


}

 /*   WebElement Home_Computers = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[1]/a"));
    WebElement Home_Electronics = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[2]/a"));
    WebElement Home_Apparel = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[3]/a"));
    WebElement Home_DigitalDownloads = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[4]/a"));
    WebElement Home_Books = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[5]/a"));
    WebElement Home_Jewelry = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[6]/a"));
    WebElement Home_GiftCards = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[2]/li[7]/a"));*/

/*   public void clickOnComputers ()
    {
        clicking(Home_Computers);
    }*/
