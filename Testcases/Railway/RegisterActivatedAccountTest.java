package Railway;

public class RegisterActivatedAccountTest extends BaseTest {
    
    AccountData accountData;

    @BeforeMethod
    public void createAccount () {
        //Create new Account
        accountData = new AccountData ();
        createAndActivateAccount(accountData);
    }

    @Test(description = "User can't create account with an already in-use email")
    public void TC10 () {
        RegisterPage registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(accountData);
        
        String expectedErrorMsg = "This email address is already in use.";
        Assert.assertEquals(registerPage.getPageErrorMessage(), expectedErrorMsg, "Error Message is not match");
    }
}