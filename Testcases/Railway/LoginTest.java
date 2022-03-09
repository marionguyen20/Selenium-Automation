package Railway;

import Constant.Constant;
import Utilities.Utilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "TC01 - User can log into Railway with valid username and password")
    public void TC01 () {

        homePage.open()
                .gotoLoginPage()
                .loginSucessToHomePage(Constant.DEFAULT_ACCOUNT);

        String actualMsg = homePage.getWelcomeMessage();
        String actualTitle = homePage.getPageTitle();

        String expectedMsg = "Welcome " + Constant.USERNAME;
        String expectedTitle = "Welcome to Safe Railway";

        Assert.assertEquals(actualTitle, expectedTitle, "Title is not match");
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not match");
    }
    @Test (description = "TC02 - User can't login with blank \"Username\" textbox")
    public void TC02 (){

        loginPage = homePage
                .open()
                .gotoLoginPage()
                .loginFail("", Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();
        String actualTile = loginPage.getPageTitle();

        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";
        String expectedTitle = "Login page";

        Assert.assertEquals(actualTile, expectedTitle, "Title is not match");
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not match");
    }
    @Test (description = "TC03 - User can't login with invalid password")
    public void TC03 () {

        loginPage = homePage
                .open()
                .gotoLoginPage()
                .loginFail(Constant.USERNAME, Utilities.generatePassword());

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not match");
    }
    @Test (description = "TC04 - User is redirected to Book ticket page after logging in")
    public void TC04 () {

        loginPage = homePage
                .open()
                .gotoBookTicketPageNotLogin();

        //Check user is direct to Login Page
        String actualMsg = loginPage.getPageTitle();
        Assert.assertEquals(actualMsg, "Login page");

        //Login
        loginPage.loginSucessToHomePage(Constant.DEFAULT_ACCOUNT);

        BookTicketPage bookTicketPage = new BookTicketPage();

        //Check Book ticket page displays with Book ticket form opens
        String actualTitle = bookTicketPage.getPageTitle();
        Assert.assertEquals(actualTitle, "Book ticket", "Title is not match");
        Assert.assertTrue(bookTicketPage.checkFormBookTicketDisplayed(),"The book ticket form is not displayed");

    }
    @Test (description = "TC05 - System shows message when user enters wrong password several times")
    public void TC05 () {
        int loginAttempt = 4;

        loginPage = homePage
                .open()
                .gotoLoginPage()
                .repeatLoginFailNTimes(loginAttempt, Constant.USERNAME, Utilities.generatePassword());

        //Check user can not login
        String actualTitle = loginPage.getPageTitle();
        String expectedTitle = "Login page";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is not match");

        //Cannot appears this message
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not match");
    }
    @Test (description = "TC06 - User is redirect to Home page after logging out")
    public void TC06 () {

        homePage
                .open()
                .gotoLoginPage()
                .loginSucessToHomePage(Constant.DEFAULT_ACCOUNT)
                .gotoContactPage()
                .logout();

        String actualTitle = homePage.getPageTitle();
        String expectedTitle = "Welcome to Safe Railway";

        Assert.assertEquals(actualTitle, expectedTitle, "Title is not match");
        Assert.assertTrue(homePage.checkLogout());
    }
}
