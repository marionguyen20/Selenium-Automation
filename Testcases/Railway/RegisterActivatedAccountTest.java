package Railway;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterActivatedAccountTest extends BaseTest {
    
    Account account;

    @BeforeMethod
    public void createAccount () throws InterruptedException {
        //Create new Account
        account = new Account ();
        createAndActivateAccount(account);
    }

    @Test(description = "User can't create account with an already in-use email")
    public void TC10 () {
        RegisterPage registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(account);
        
        String expectedErrorMsg = "This email address is already in use.";
        Assert.assertEquals(registerPage.getPageErrorMessage(), expectedErrorMsg, "Error Message is not match");
    }
}