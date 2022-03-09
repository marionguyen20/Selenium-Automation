package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends GeneralPage {

    //Locator
    private final By _txtEmail = By.id("email");
    private final By _txtPassword = By.id("password");
    private final By _txtCfPassword = By.id("confirmPassword");
    private final By _pid = By.id("pid");
    private final By _btnRegister = By.xpath("//p[@class = 'form-actions']//input[@value='Register']");
    private final By _lblErrorMsg = By.xpath("//div[@id='page']//p[@class='message error']");
    private final String _errorTemplate = "//form[@id = 'RegisterForm']//label[@for = '%s'][@class='validation-error']";

    //Elements
    public WebElement getTxtEmail () {
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword () {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtCfPassword () {
        return Constant.WEBDRIVER.findElement(_txtCfPassword);
    }
    public WebElement getPid () {
        return Constant.WEBDRIVER.findElement(_pid);
    }
    public WebElement getBtnRegister () {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public WebElement getLblErrorMsg () {
        return Constant.WEBDRIVER.findElement(_lblErrorMsg);
    }
    public WebElement getLblFieldErrorMsg (String field) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(_errorTemplate, field)));
    }
    //Methods
    public void submitRegisterForm (String email, String password, String pid) {
        enter(this.getTxtEmail(), email);
        enter(this.getTxtPassword(), password);
        enter(this.getTxtCfPassword(), password);
        enter(this.getPid(), pid);
        this.getBtnRegister().submit();
    }
    public RegisterPage register (AccountData accountData) {
        submitRegisterForm(accountData.getEmail(), accountData.getPassword(), accountData.getPid());
        return this;
    }
    public String getErrorMsg () {
        return this.getLblErrorMsg().getText();
    }
    public String getFieldErrorMsg (String field) {
        return this.getLblFieldErrorMsg(field).getText();
    }
}
