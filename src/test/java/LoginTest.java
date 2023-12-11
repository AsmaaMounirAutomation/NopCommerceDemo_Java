import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;

    @Test (priority = 1)
    public void validLogin()
    {
        homePage=new HomePage(driver);
        loginPage= homePage.clickOnLogin();

        loginPage.enterEmailLogin("ebf12c4f8ad1@drmail.in");
        loginPage.enterPassLogin("3151991@As");
        loginPage.clickOnLogin();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        boolean logoutbutton= loginPage.assertValidLogin().isDisplayed();
        Assert.assertTrue(logoutbutton,"Successful login");

        loginPage.logoutClicking().click();
//        driver.navigate().back();
    }

    @Test (priority = 2)
    public void invalidCredentials()
    {
        homePage=new HomePage(driver);
        loginPage=homePage.clickOnLogin();

        loginPage.enterEmailLogin("d61adf3ec762@drmail.in");
        loginPage.enterPassLogin("315199s");
        loginPage.clickOnLogin();

        String erroeMsg= loginPage.failedLogin();
        Assert.assertTrue(erroeMsg.contains("Returning Customer"));
    }

    @Test(priority = 3)
    public void testEmptyFields()
    {
        homePage=new HomePage(driver);
        loginPage=homePage.clickOnLogin();

        loginPage.enterEmailLogin("");
        loginPage.enterPassLogin("315199s");
        loginPage.clickOnLogin();

        boolean emailError= loginPage.testEmptyFields().isDisplayed();
        Assert.assertTrue(emailError, "email error appeared.");

    }
    @Test(priority = 4)
    public void rememberMeFunctionality ()
    {
        homePage=new HomePage(driver);
        loginPage= homePage.clickOnLogin();

        loginPage.enterEmailLogin("ebf12c4f8ad1@drmail.in");
        loginPage.enterPassLogin("3151991@As");
        loginPage.rememberMeFunctionality().click();
        loginPage.clickOnLogin();
        loginPage.logoutClicking().click();

        loginPage= homePage.clickOnLogin();
        loginPage.clickOnLogin();


        String erroeMsg= loginPage.failedLogin();
        Assert.assertFalse(erroeMsg.contains("Returning Customer")); //failed TC

    }




}
