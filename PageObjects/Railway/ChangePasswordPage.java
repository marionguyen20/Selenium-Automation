package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Locators
    private final By currentPassTxt = By.id("currentPassword");
    private final By newPassTxt = By.id("newPassword");
    private final By confirmPassTxt = By.id("confirmPassword");
    private final By changePassBtn = By.xpath("//input[@type = 'submit'][@value = 'Change Password']");
    private final By lblFormErrorMsg = By.xpath("//div[@id='content']//p[@class = 'message error']");
    private final By lblFieldErrorMsg = By.xpath("//label[@class='validation-error']");

    //Elements
    protected WebElement getCurrentPassTxt () {
        return Constant.WEBDRIVER.findElement(currentPassTxt);
    }
    protected WebElement getNewPassTxt () {
        return Constant.WEBDRIVER.findElement(newPassTxt);
    }
    protected WebElement getConfirmPassTxt () {
        return Constant.WEBDRIVER.findElement(confirmPassTxt);
    }
    protected WebElement getChangePassBtn () {
        return Constant.WEBDRIVER.findElement(changePassBtn);
    }
    protected WebElement getLblFormErrorMsg () {
        return Constant.WEBDRIVER.findElement(lblFormErrorMsg);
    }
    protected WebElement getLblFieldErrorMsg () {
        return Constant.WEBDRIVER.findElement(lblFieldErrorMsg);
    }

    //Methods
    protected void submitChangePassForm (String currentPass, String newPass, String cfPass) {
        enter(this.getCurrentPassTxt(), currentPass);
        enter(this.getNewPassTxt(), newPass);
        enter(this.getConfirmPassTxt(), cfPass);
        this.getChangePassBtn().submit();
    }
    protected ChangePasswordPage changePass (String currentPass, String newPass, String cfPass) {
        submitChangePassForm(currentPass, newPass, cfPass);
        return this;
    }
    protected String getFormErrorMsg () {
        return this.getLblErrorMsg().getText().trim();
    }
    protected String getFieldErrorMsg () {
        return this.getLblFieldErrorMsg().getText().trim();
    }
}
