package MailBox;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginMailBoxPage {

    //Locators
    private final By usernameTxt = By.id("rcmloginuser");
    private final By passwordTxt = By.id("rcmloginpwd");
    private final By loginBtn = By.id("rcmloginsubmit");

    //Elements
    protected WebElement getUsernameTxt () {
        return Constant.WEBDRIVER.findElement(usernameTxt);
    }
    protected WebElement getPasswordTxt () {
        return Constant.WEBDRIVER.findElement(passwordTxt);
    }
    protected WebElement getLoginBtn () {
        return Constant.WEBDRIVER.findElement(loginBtn);
    }

    //Methods
    public LoginMailBoxPage open () {
        Constant.WEBDRIVER.get(Constant.MAILBOX_URL);
        return this;
    }
    public void submitLoginMailBox (String username, String password){
        this.getUsernameTxt().sendKeys(username);
        this.getPasswordTxt().sendKeys(password);
    }
    public MailBoxPage loginMailBox (String username, String password) {
        submitLoginMailBox(username, password);
        this.getLoginBtn().click();
        return new MailBoxPage();
    }
}
