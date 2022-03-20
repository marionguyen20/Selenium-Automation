package Railway;

import Constant.Constant;
import MailBox.LoginMailBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Class encapsulate the Login Page
public class LoginPage extends GeneralPage {
    //Locators

    private final By _linkForgetPass = By.xpath("//div[@id='content']//a[contains(text(), 'Forgot Password page')]");
    private final By _titlePageChangeForm = By.xpath("//div[@id='content']//form//legend");


    //Elements
    public WebElement getLinkForgetPass () {
        return Constant.WEBDRIVER.findElement(_linkForgetPass);
    }
    public WebElement getPageChangeForm () {
        return Constant.WEBDRIVER.findElement(_titlePageChangeForm);
    }
    protected WebElement getUsernameTxt () {
        return getTxtElement("username");
    }
    protected WebElement getResetToken () {
        return getTxtElement("resetToken");
    }
    protected WebElement getLoginBtn () {
        return getBtnElement("login");
    }
    protected WebElement getSendInstructionBtn () {
        return getBtnElement("Send Instructions");
    }
    protected WebElement getResetTokenFieldError () {
        return getFieldErrorMsg("resetToken")
    }

    //Methods
    //Fill information
    protected void submitLoginForm (String username, String password) {
        enter(this.getUsernameTxt(), username);
        enter(this.getPasswordTxt(), password);
        this.getLoginBtn().click();
    }
    //Login Method return Homepage
    public HomePage loginSucessToHomePage(AccountData accountData) {
        //Login
        this.submitLoginForm(accountData.getEmail(), accountData.getPassword());
        //Land on Home Page
        return new HomePage();
    }
    public LoginPage loginFail(String username, String password) {
        this.submitLoginForm(username, password);
        return this;
    }
    public LoginPage repeatLoginFailNTimes (int n, String username, String password) {
        for (int i = 0; i < n; i++) {
            this.loginFail(username, password);
        }
        return this;
    }
    public LoginPage forgotPassword () {
        this.getLinkForgetPass().click();
        return this;
    }
    public LoginMailBoxPage sendInstruction (String email) {
        enter(getEmailTxt(), email);
        getSendInstructionBtn().click();
        return new LoginMailBoxPage();
    }
    public boolean checkPageChangeFormDisplayed () {
        return this.getPageChangeForm().isDisplayed();
    }
    public void fillPageChangeForm (String newPass, String CfPass) {
        enter(getNewPasswordTxt(), newPass);
        enter(getConfirmPasswordTxt(), CfPass);
    }
    public LoginPage submitPageChangeFormNoToken (String newPass, String CfPass) {
        fillPageChangeForm(newPass, CfPass);
        getResetToken().clear();
        getSendInstructionBtn().submit();
        return this;
    }
    public LoginPage submitPageChangeForm (String newPass, String CfPass) {
        fillPageChangeForm(newPass, CfPass);
        getSendInstructionBtn().submit();
        return this;
    }

}
