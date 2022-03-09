package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Class encapsulate the Login Page
public class LoginPage extends GeneralPage {
    //Locators
    private final By _txtUsername = By.id("username");
    private final By _txtPassword = By.id("password");
    private final By _btnLogin = By.xpath("//input[@value ='login']");
    private final By _lblLoginErrorMsg = By.xpath("//div[@id='content']//p[@class = 'message error LoginForm']");

    //Elements
    public WebElement getTxtUsername () {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }
    public WebElement getTxtPassword () {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }
    public WebElement getLblLoginErrorMsg () {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }

    //Methods
    //Fill information
    protected void submitLoginForm (String username, String password) {
        enter(this.getTxtUsername(), username);
        enter(this.getTxtPassword(), password);
        this.getBtnLogin().click();
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
    public String getLoginErrorMsg () {
        return this.getLblLoginErrorMsg().getText();
    }
    public LoginPage repeatLoginFailNTimes (int n, String username, String password) {
        for (int i = 0; i < n; i++) {
            this.loginFail(username, password);
        }
        return this;
    }

}
