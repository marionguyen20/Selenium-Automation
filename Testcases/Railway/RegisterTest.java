package Railway;

import Constant.Constant;
import MailBox.LoginMailBoxPage;
import MailBox.MailBoxPage;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    AccountData accountData = new AccountData();
    RegisterPage registerPage = new RegisterPage();

    @Test (description = "TC07 - User can create new account")
    public void TC07 () {

        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(accountData);

        String actualMsg = registerPage.getPageTitle();
        String expectedMsg = "Thank you for registering your account";
        Assert.assertEquals(actualMsg, expectedMsg, "Title is not match");
    }
    @Test(description = "User can't login with an account hasn't been activated")
    public void TC08 () {

        String email = accountData.getEmail();
        String password = accountData.getPassword();

        loginPage = homePage
                .open()
                .gotoLoginPage()
                .loginFail(email, password);

        String actualTitle = loginPage.getPageTitle();
        String actualMsg = loginPage.getLoginErrorMsg();

        String expectedTitle = "Login page";
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualTitle, expectedTitle, "Title is not match");
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not match");

    }
    public void ActivateAccount (String email) throws InterruptedException {
        //Activate Account
        LoginMailBoxPage loginMailBoxPage = new LoginMailBoxPage();
        MailBoxPage mailBoxPage = loginMailBoxPage
                .open()
                .loginMailBox(Constant.USERNAME_MAILBOX, Constant.PASSWORD_MAILBOX);
        mailBoxPage.activateAccount(email);
        Utilities.closeWindow();

    }
    @Test(description = "User can't change password when New Password and Confirm Password are different")
    public void TC09 () throws InterruptedException {
        ActivateAccount(accountData.getEmail());
        //Change Password
        String newPass = "a123:\"/{}!@$\\";
        String cfPass = "/{}!@$\\";

        ChangePasswordPage changePasswordPage = homePage
                .open()
                .gotoLoginPage()
                .loginSucessToHomePage(accountData)
                .gotoChangePasswordPage()
                .changePass(accountData.getPassword(), newPass, cfPass);

        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        String actualMsg = changePasswordPage.getErrorMsg();

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not match");
    }
    @Test(description = "User can't create account with an already in-use email")
    public void TC10 () {
        registerPage = homePage
                .open()
                .gotoRegisterPage()
                .register(accountData);

        String actualErrorMsg = registerPage.getErrorMsg();
        String expectedErrorMsg = "This email address is already in use.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error Message is not match");
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
