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
    private final By lblFieldErrorMsg = By.xpath("//label[@class='validation-error']");
    private final String fieldEerrorTemplate = "//form[@id = 'ChangePW']//label[@for = '%s'][@class='validation-error']";

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
    public WebElement getLblFieldErrorMsg (String field) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(fieldEerrorTemplate, field)));
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
    public String getFieldErrorMsg (String field) {
        return this.getLblFieldErrorMsg(field).getText().trim();
    }
}
