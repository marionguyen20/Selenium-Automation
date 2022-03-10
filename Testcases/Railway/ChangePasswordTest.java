package Railway;

public class ChangePasswordTest extends BaseTest {
    
    AccountData accountData;

    @BeforeMethod
    public void createAccount () {
        //Create new Account
        accountData = new AccountData ();
        createAndActivateAccount(accountData);
    }
    
    @Test(description = "User can't change password when New Password and Confirm Password are different")
    public void TC09 () throws InterruptedException {

        String newPass = "a123:\"/{}!@$\\";
        String cfPass = "/{}!@$\\";

        ChangePasswordPage changePasswordPage = homePage
                .open()
                .gotoLoginPage()
                .loginSucessToHomePage(accountData)
                .gotoChangePasswordPage()
                .changePass(accountData.getPassword(), newPass, cfPass);

        String expectedTitle = "Change password";
        String expectedPageErrorMsg = "Password change failed. Please correct the errors and try again.";
        String expectedCfPassErrorMsg = "The password confirmation does not match the new password.";

        Assert.assertEquals(changePasswordPage.getPageTitle(), expectedTitle, "Title is not match");
        Assert.assertEquals(changePasswordPage.getPageErrorMessage(), expectedPageErrorMsg, "Page error message is not match");
        Assert.assertEquals(changePasswordPage.getFieldErrorMsg("confirmPassword"), expectedCfPassErrorMsg, "Confirm Password field error message is not match");
    }

    @Test(description = "Errors display when password reset token is blank")
    public void TC12 () {
        
    }






}