package Railway;

public class LoginUnactivatedAccountTest extends BaseTest {
    
    HomePage homePage = new HomePage ();
    LoginPage loginPage;
    AccountData accountData;

    @BeforeMethod
    public void createAccount () {
        accountData = new AccountData ();
        RegisterPage registerPage = homePage
                .open()
                .gotoRegisterPage()
                .createAccount(accountData);
    }

    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08 () {

        loginPage = homePage
                .open()
                .gotoLoginPage()
                .loginFail(accountData.getEmail(), accountData.getPassword());

        String actualTitle = loginPage.getPageTitle();
        String actualMsg = loginPage.getLoginErrorMsg();

        String expectedTitle = "Login page";
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualTitle, expectedTitle, "Title is not match");
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not match");

    }

}