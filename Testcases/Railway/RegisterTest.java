package Railway;

import Constant.Constant;
import MailBox.LoginMailBoxPage;
import MailBox.MailBoxPage;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    HomePage homePage = new HomePage();
    AccountData accountData;
    RegisterPage registerPage;

    @Test (description = "TC07 - User can create new account")
    public void TC07 () {
        accountData = new AccountData();
        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .createAccount(accountData);

        String actualMsg = registerPage.getPageTitle();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "Title is not match");
    }


    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11 () {
        AccountData accountData1 = new AccountData(Utilities.generateEmail(), "","");

        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(accountData1);

        String actualErrorMsg = registerPage.getErrorMsg();
        String actualPassErrorMsg = registerPage.getFieldErrorMsg("password");
        String actualPidErrorMsg = registerPage.getFieldErrorMsg("pid");

        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedPassErrorMsg = "Invalid password length";
        String expectedPidErrorMsg = "Invalid ID length";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error Message is not match");
        Assert.assertEquals(actualPassErrorMsg, expectedPassErrorMsg, "Error Password is not match");
        Assert.assertEquals(actualPidErrorMsg, expectedPidErrorMsg, "Error Pid is not match");
    }
}
