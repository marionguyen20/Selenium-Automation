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
    private final By lblWelcomeMessage = By.xpath("//div[@class= 'account']//strong[contains(text(), 'Welcome')]");
    private final By hPageTitle = By.xpath("//div[@id = 'content']//h1");

    //Elements
    protected WebElement getTab (String tabName) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(menuTemplate, tabName)));
    }
    protected WebElement getLblWelcomeMessage () {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }
    protected WebElement getHPageTitle () {
        return Constant.WEBDRIVER.findElement(hPageTitle);
    }

    //Methods
    public String getWelcomeMessage () {
        return this.getLblWelcomeMessage().getText();
    }
    protected boolean isDisplayed (WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Here");
            return false;
        }
    }
    public boolean checkLogout () {
        return isDisplayed(this.getTab("Login"));
    }
    public String getPageTitle () {
        return this.getHPageTitle().getText();
    }
    protected void enter (WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    protected void scroll (WebElement element) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("argument[0].scrollIntoView(true);", element);
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

}