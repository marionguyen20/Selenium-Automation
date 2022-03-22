package Railway;

import Constant.Constant;
import MailBox.MailBoxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


// class contains all general UI elements and methods that shared across other pages (Login, Logout)
public class GeneralPage {

    //Locators
    private final String menuTemplate = "//div[@id = 'menu']//a[span[text() ='%s']]";
    private final String _errorTemplate = "label[@for = '%s'][@class='validation-error']";
    private final By lblWelcomeMessage = By.xpath("//div[@class= 'account']//strong[contains(text(), 'Welcome')]");
    private final By lblPageErrorMessage = By.xpath("//div[@id = 'content']//p[contains(@class, 'message error')]");
    private final By hPageTitle = By.xpath("//div[@id = 'content']//h1");

    //Elements
    protected WebElement getTab (String tabName) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(menuTemplate, tabName)));
    }
    protected WebElement getLblFieldErrorMsg (String field) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(_errorTemplate, field)));
    }
    protected WebElement getConfirmPassFieldError () {
        return getFieldErrorMsg("confirmPassword");
    }
    protected WebElement getLblWelcomeMessage () {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getLblPageErrorMessage () {
        return Constant.WEBDRIVER.findElement(lblPageErrorMessage);
    }
    protected WebElement getHPageTitle () {
        return Constant.WEBDRIVER.findElement(hPageTitle);
    }
        public WebElement getTxtElement (String txtName) {
        return Constant.WEBDRIVER.findElement(By.id(txtName));
    }
    protected WebElement getEmailTxt () {
        return getTxtElement("email");
    }
    protected WebElement getPasswordTxt () {
        return getTxtElement("password");
    }
    protected WebElement getNewPasswordTxt () {
        return getTxtElement("newPassword");
    }
    protected WebElement getConfirmPasswordTxt () {
        return getTxtElement("confirmPassword");
    }
    protected WebElement getBtnElement (String btnName) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format("//input[@value ='%s']", btnName)));
    }


    //Methods
    public String getWelcomeMessage () {
        return this.getLblWelcomeMessage().getText();
    }
    public String getPageErrorMessage () {
        return this.getLblPageErrorMessage().getText().trim();
    }
    public Strng getFieldErrorMessage (String field) {
        return this.getLblFieldErrorMsg(field).geText().trim();
    }
    public boolean isDisplayed (WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean checkLogout () {
        return isDisplayed(this.getTab("Login"));
    }
    public String getPageTitle () {
        return this.getHPageTitle().getText();
    }
    public void enter (WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public void scroll (WebElement element) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("argument[0].scrollIntoView(true);", element);
    }
    public void select (WebElement element, String text) {
        Select selectElement = new Select (element);
        selectElement.selectByVisibleText(text);
    }
    public void waitForElementStaleness (WebElement element) {
        try {
            WebDriverWait wdw = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(2));
            wdw.until(ExpectedConditions.stalenessOf(element));
        }
        catch (Exception e) {}
    }

    //Go to Page methods
    public LoginPage gotoLoginPage () {
        this.getTab("Login").click();
        return new LoginPage();
    }
    public BookTicketPage gotoBookTicketPageLogin () {
        this.getTab("Book ticket").click();
        return new BookTicketPage();
    }
    public LoginPage gotoBookTicketPageNotLogin () {
        this.getTab("Book ticket").click();
        return new LoginPage();
    }
    public ContactPage gotoContactPage () {
        this.getTab("Contact").click();
        return new ContactPage();
    }
    public RegisterPage gotoRegisterPage () {
        this.getTab("Register").click();
        return new RegisterPage();
    }
    public ChangePasswordPage gotoChangePasswordPage () {
        this.getTab("Change password").click();
        return new ChangePasswordPage();
    }
    public HomePage logout () {
        this.getTab("Log out").click();
        return new HomePage();
    }
    public String getFieldErrorMsg (String field) {
        return this.getLblFieldErrorMsg(field).getText();
    }
}


