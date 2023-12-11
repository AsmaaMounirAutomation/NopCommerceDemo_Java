import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

   private WebElement emailBox =driver.findElement(By.id("Email"));
    private WebElement passBox =driver.findElement(By.id("Password"));
    private WebElement loginButton= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));

    private WebElement remeberMeBox= driver.findElement(By.xpath("//input[@type='checkbox']"));

    public void enterEmailLogin (String emailLogin)
    {
        entering(emailBox,emailLogin);
    }

    public void enterPassLogin (String passLogin)
    {
        entering(passBox,passLogin);
    }

    public void clickOnLogin ()
    {
        clicking(loginButton);
    }

    public WebElement assertValidLogin()
    {
        WebElement logoutButton =driver.findElement(By.linkText("Log out"));
       return logoutButton;
    }

    public String failedLogin()
    {
        WebElement errorMsg =driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/strong"));
        return errorMsg.getText();
    }

    public WebElement testEmptyFields ()
    {
        WebElement emailError = driver.findElement(By.xpath("//span[@id='Email-error']"));
        return emailError;
    }

    public WebElement rememberMeFunctionality()
    {
        return remeberMeBox;
    }


    public WebElement logoutClicking ()
    {
        WebElement logout= driver.findElement(By.xpath("//a[@href='/logout']"));
      return   logout;
    }

}
