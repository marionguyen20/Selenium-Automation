package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends GeneralPage {

    //Locator

    //Elements

    public WebElement getPidTxt () {
        return getFieldErrorMsg("pid");
    }
    public WebElement getPasswordFieldError () {
        return getFieldErrorMsg("password");
    }
    public WebElement getPidFieldError () {
        return getFieldErrorMsg("pid");
    }
    public WebElement getRegisterBtn () {
        return getBtnElement("Register");
    }
    
    //Methods
    public void submitRegisterForm(String email, String password, String pid) {
        enter(getEmailTxt(), email);
        enter(getPasswordTxt(), password);
        enter(getConfirmPasswordTxt(), password);
        enter(getPidTxt(), pid);
        getRegisterBtn().submit();
    }

    public RegisterPage register(AccountData accountData) {
        submitRegisterForm(accountData.getEmail(), accountData.getPassword(), accountData.getPid());
        return this;
    }
}

