package Railway;

import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    Account account;
    RegisterPage registerPage;

    @Test (description = "TC07 - User can create new account")
    public void TC07 () {
        account = new Account();
        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(account);

        String expectedTitle = "Thank you for registering your account";
        Assert.assertEquals(registerPage.getPageTitle(), expectedTitle, "Title is not match");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11 () {
        account = new Account(Utilities.generateEmail(), "","");

        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(account);

        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedPassErrorMsg = "Invalid password length.";
        String expectedPidErrorMsg = "Invalid ID length.";

        Assert.assertEquals(registerPage.getPageErrorMessage(), expectedErrorMsg, "Error Message is not match");
        Assert.assertEquals(registerPage.getPasswordFieldError(), expectedPassErrorMsg, "Error Password is not match");
        Assert.assertEquals(registerPage.getPidFieldError(), expectedPidErrorMsg, "Error Pid is not match");
    }
}
