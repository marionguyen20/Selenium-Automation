package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locators

    //Elements
    protected WebElement getChangePasswordBtn () {
        return getBtnElement("Change Password");
    }
    protected WebElement getCurrentPassword () {
        return getTxtElement("currentPassword");
    }
    
    //Methods
    protected void submitChangePassForm (String currentPass, String newPass, String cfPass) {
        enter(getCurrentPassTxt(), currentPass);
        enter(getNewPasswordTxt(), newPass);
        enter(getConfirmPasswordTxt (), cfPass);
        this.getChangePasswordBtn().submit();
    }
    protected ChangePasswordPage changePass (String currentPass, String newPass, String cfPass) {
        submitChangePassForm(currentPass, newPass, cfPass);
        return this;
    }
}
