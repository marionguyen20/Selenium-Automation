package Railway;

import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    AccountData accountData;
    RegisterPage registerPage;

    @Test (description = "TC07 - User can create new account")
    public void TC07 () {
        accountData = new AccountData();
        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(accountData);

        String expectedTitle = "Thank you for registering your account";
        Assert.assertEquals(registerPage.getPageTitle(), expectedTitle, "Title is not match");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11 () {
        accountData = new AccountData(Utilities.generateEmail(), "","");

        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(accountData);

        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedPassErrorMsg = "Invalid password length";
        String expectedPidErrorMsg = "Invalid ID length";

        Assert.assertEquals(registerPage.getPageErrorMessage(), expectedErrorMsg, "Error Message is not match");
        Assert.assertEquals(registerPage.getFieldErrorMsg("password"), expectedPassErrorMsg, "Error Password is not match");
        Assert.assertEquals(registerPage.getFieldErrorMsg("pid"), expectedPidErrorMsg, "Error Pid is not match");
    }
}
