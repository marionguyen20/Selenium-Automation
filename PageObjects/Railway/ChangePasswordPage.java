package Railway;

import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locators

    //Elements
    protected WebElement getChangePasswordBtn () {
        return getBtnElement("Change Password");
    }
    protected WebElement getCurrentPasswordTxt () {
        return getTxtElement("currentPassword");
    }
    
    //Methods
    protected void submitChangePassForm (String currentPass, String newPass, String cfPass) {
        enter(getCurrentPasswordTxt(), currentPass);
        enter(getNewPasswordTxt(), newPass);
        enter(getConfirmPasswordTxt (), cfPass);
        this.getChangePasswordBtn().submit();
    }
    protected ChangePasswordPage changePass (String currentPass, String newPass, String cfPass) {
        submitChangePassForm(currentPass, newPass, cfPass);
        return this;
    }
}
