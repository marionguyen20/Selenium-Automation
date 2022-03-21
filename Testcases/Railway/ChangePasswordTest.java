package Railway;

import Constant.Constant;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
    
    Account account;
    LoginPage loginPage;

    @BeforeMethod
    public void createAccount () throws InterruptedException {
        //Create new Account
        account = new Account ();
        createAndActivateAccount(account);
    }
    
    @Test(description = "User can't change password when New Password and Confirm Password are different")
    public void TC09 () throws InterruptedException {

        String newPass = "a123:\"/{}!@$\\";
        String cfPass = "/{}!@$\\";

        ChangePasswordPage changePasswordPage = homePage
                .open()
                .gotoLoginPage()
                .loginSucessToHomePage(account)
                .gotoChangePasswordPage()
                .changePass(account.getPassword(), newPass, cfPass);

        String expectedTitle = "Change password";
        String expectedPageErrorMsg = "Password change failed. Please correct the errors and try again.";
        String expectedCfPassErrorMsg = "The password confirmation does not match the new password.";

        Assert.assertEquals(changePasswordPage.getPageTitle(), expectedTitle, "Title is not match");
        Assert.assertEquals(changePasswordPage.getPageErrorMessage(), expectedPageErrorMsg, "Page error message is not match");
        Assert.assertEquals(changePasswordPage.getConfirmPassFieldError(), expectedCfPassErrorMsg, "Confirm Password field error message is not match");
    }
    public LoginPage resetPassword () throws InterruptedException {
        loginPage = homePage
                .open()
                .gotoLoginPage()
                .forgotPassword()
                .sendInstruction(account.getEmail())
                .loginMailBox(Constant.USERNAME_MAILBOX, Constant.PASSWORD_MAILBOX)
                .resetPassword(account.getEmail());
        Utilities.moveToCurrentWindow();
        return loginPage;
    }
    @Test(description = "Errors display when password reset token is blank")
    public void TC12 () throws InterruptedException {
        loginPage = resetPassword();

        Assert.assertTrue(loginPage.checkPageChangeFormDisplayed());
        String password = Utilities.generatePassword();
        loginPage.submitPageChangeFormNoToken(password, password);

        Assert.assertEquals(loginPage.getPageErrorMessage(), "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.");
        Assert.assertEquals(loginPage.getResetTokenFieldError(), "The password reset token is invalid.");
    }
    @Test(description = "Errors display if password and confirm password don't match when resetting password")
    public void TC13 () throws InterruptedException {
        loginPage = resetPassword();

        Assert.assertTrue(loginPage.checkPageChangeFormDisplayed());
        loginPage.submitPageChangeForm(Utilities.generatePassword(), Utilities.generatePassword());

        Assert.assertEquals(loginPage.getPageErrorMessage(), "Could not reset password. Please correct the errors and try again.");
        Assert.assertEquals(loginPage.getConfirmPassFieldError(),"The password confirmation did not match the new password.");
    }

}