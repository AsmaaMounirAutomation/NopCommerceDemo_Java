import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest extends TestBase {
   private HomePage homePage;
    private RegisterPage registerPage;

    @Test (priority = 1)
    public void validRegister ()
    {
        homePage= new HomePage(driver);
        registerPage= homePage.clickOnRegister();

        registerPage.clickOnFemale();
        registerPage.enterFistName("Asmaa");
        registerPage.enterLastName("Mounir");
        registerPage.selectbirthDay("31");
        registerPage.selectbirthMonth("5");
        registerPage.selectbirthYear("1991");
        registerPage.enterEmail("ebf12c4f8ad1@drmail.in");
        registerPage.enterCompany("itworx");
        registerPage.enterPassword("3151991@As");
        registerPage.reenterPassword("3151991@As");
        registerPage.RegisterButtonClick();

        String actualText=registerPage.confirmRegistration();
        Assert.assertTrue(actualText.contains("Your registration completed"));


    }

    @Test(priority = 2)
    public void testIncompleteRegistration()
    {
        homePage=new HomePage(driver);
        registerPage=homePage.clickOnRegister();

        registerPage.clickOnFemale();
        registerPage.enterFistName("Asmaa");
        registerPage.enterLastName("Mounir");
        registerPage.selectbirthDay("31");
        registerPage.selectbirthMonth("5");
        registerPage.selectbirthYear("1991");
        registerPage.enterEmail("becdfeb76057@drmail.in");
        registerPage.enterCompany("itworx");
        registerPage.enterPassword("3151991@As");
        registerPage.RegisterButtonClick();

        String actualText=registerPage.incompleteReg();
        Assert.assertTrue(actualText.contains("Password is required."));


    }

    @Test(priority = 3)
    public void testMismatchedPasswords()
    {
        homePage=new HomePage(driver);
        registerPage=homePage.clickOnRegister();

        registerPage.clickOnFemale();
        registerPage.enterFistName("Asmaa");
        registerPage.enterLastName("Mounir");
        registerPage.selectbirthDay("31");
        registerPage.selectbirthMonth("5");
        registerPage.selectbirthYear("1991");
        registerPage.enterEmail("becdfeb76057@drmail.in");
        registerPage.enterCompany("itworx");
        registerPage.enterPassword("3151991@As");
        registerPage.reenterPassword("3151991As");
        registerPage.RegisterButtonClick();

        String actualText=registerPage.mismatchPasswordMsg();
        Assert.assertTrue(actualText.contains("The password and confirmation password do not match."));


    }

    @Test(priority = 4)
    public void testExistingEmailRegistration()
    {
        homePage= new HomePage(driver);
        registerPage= homePage.clickOnRegister();

        registerPage.clickOnFemale();
        registerPage.enterFistName("Asmaa");
        registerPage.enterLastName("Mounir");
        registerPage.selectbirthDay("31");
        registerPage.selectbirthMonth("5");
        registerPage.selectbirthYear("1991");
        registerPage.enterEmail("80149a648b5e@drmail.in");
        registerPage.enterCompany("itworx");
        registerPage.enterPassword("3151991@As");
        registerPage.reenterPassword("3151991@As");
        registerPage.RegisterButtonClick();

        String actualText=registerPage.existingEmail();
        Assert.assertTrue(actualText.contains("The specified email already exists"));

    }

}
