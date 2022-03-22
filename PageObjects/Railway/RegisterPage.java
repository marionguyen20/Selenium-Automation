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
        return getLblFieldErrorMsg("pid");
    }
    public WebElement getPasswordFieldError () {
        return getLblFieldErrorMsg("password");
    }
    public WebElement getPidFieldError () {
        return getLblFieldErrorMsg("pid");
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

    public RegisterPage register(Account account) {
        submitRegisterForm(account.getEmail(), account.getPassword(), account.getPid());
        return this;
    }
}

