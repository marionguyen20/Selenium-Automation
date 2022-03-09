package Railway;

public class ChangePasswordTest extends BaseTest {
    
    HomePage homePage = new HomePage ();
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
        String expectedFormErrorMsg = "Password change failed. Please correct the errors and try again.";
        String expectedFieldErrorMsg = "";

        String actualTitle = changePasswordPage.getPageTitle();
        String actualFormErrorMsg = changePasswordPage.getFormErrorMsg();
        String actualFieldErrorMsg = changePasswordPage.getFieldErrorMsg();

        Assert.assertEquals(actualTitle, expectedTitle, "Title is not match");
        Assert.assertEquals(actualFormErrorMsg, expectedFormErrorMsg, "Form error message is not match");
        Assert.assertEquals(actualFieldErrorMsg, expectedFieldErrorMsg, "Field error message is not match");
    }






}