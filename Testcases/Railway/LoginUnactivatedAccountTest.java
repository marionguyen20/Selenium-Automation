package Railway;

public class LoginUnactivatedAccountTest extends BaseTest {
    
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

        LoginPage loginPage = homePage
                .open()
                .gotoLoginPage()
                .loginFail(accountData.getEmail(), accountData.getPassword());

        String expectedTitle = "Login page";
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(loginPage.getPageTitle(), expectedTitle, "Title is not match");
        Assert.assertEquals(loginPage.getPageErrorMessage(), expectedMsg, "Message is not match");

    }

}