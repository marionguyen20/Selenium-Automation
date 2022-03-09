package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By _formBookTicket = By.xpath("//div[@id = 'content']//form[.//legend[text()='Book ticket form']]");

    //Elements
    public WebElement getFormBookTicket () {
        return Constant.WEBDRIVER.findElement(_formBookTicket);
    }

    //Methods
    public boolean checkFormBookTicketDisplayed () {
        return isDisplayed(this.getFormBookTicket());
    }
}
