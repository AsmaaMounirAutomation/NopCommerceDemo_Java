import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    private WebElement gender = driver.findElement(By.id("gender-female"));
    private WebElement firstName =driver.findElement(By.id("FirstName"));
    private WebElement lastName =driver.findElement(By.id("LastName"));
    private  WebElement birthdateDay =driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]"));
    private WebElement birthdateMonth =driver.findElement(By.xpath(" /html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]"));
    private WebElement birthdateYear =driver.findElement(By.xpath(" /html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]"));
    private WebElement email = driver.findElement(By.id("Email"));
    private WebElement company = driver.findElement(By.id("Company"));
    private WebElement password = driver.findElement(By.id("Password"));
    private WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
    private WebElement registerButton = driver.findElement(By.id("register-button"));



   public void clickOnFemale()
   {
     clicking(gender);
   }

   public void enterFistName (String fname)
   {
       entering(firstName,fname);
   }

    public void enterLastName (String lname)
    {
        entering(lastName,lname);
    }

    public void selectbirthDay(String dvalue)
    {
        dropDown(birthdateDay,dvalue);
    }
    public void selectbirthMonth(String Mvalue)
    {
        dropDown(birthdateMonth,Mvalue);
    }

    public void selectbirthYear(String Yvalue)
    {
        dropDown(birthdateYear,Yvalue);
    }

    public void enterEmail(String emailText)
    {
        entering(email,emailText);
    }

    public void enterCompany(String companyText)
    {
        entering(company,companyText);
    }


    public void enterPassword(String passwordText)
    {
        entering(password,passwordText);
    }

    public void reenterPassword(String confirmPassText)
    {
        entering(confirmPassword,confirmPassText);
    }


    public void RegisterButtonClick()
    {
        clicking(registerButton);
    }

    public String confirmRegistration()
    {
       WebElement getRegistrationText = driver.findElement(By.xpath("//div[@class='result']"));
        return getRegistrationText.getText();
    }

    public String mismatchPasswordMsg()
    {
        WebElement getmismatchMsg= driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']"));
        return getmismatchMsg.getText();
    }

    public String incompleteReg()
    {
        WebElement getincompleteReg =driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']"));
        return getincompleteReg.getText();
    }

    public String existingEmail ()
    {
        WebElement existingemail = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li"));
        return existingemail.getText();
    }

}
