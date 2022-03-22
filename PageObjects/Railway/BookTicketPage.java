package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends GeneralPage {
    //Locators
    private final By _formBookTicket = By.xpath("//div[@id = 'content']//form[.//legend[text()='Book ticket form']]");
    private final By _btnBookTicket = By.xpath("//form//input[@value='Book ticket']");

    //Elements
    public WebElement getFormBookTicket () {
        return Constant.WEBDRIVER.findElement(_formBookTicket);
    }
    public WebElement getBookTicketElement (String name) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format("//form//select[@name='%s']", name)));
    }
    public WebElement getDepartDateCbb () {
        return getBookTicketElement ("Date");
    }
    public WebElement getDepartFromCbb () {
        return getBookTicketElement("DepartStation");
    }
    public WebElement getArriveAtCbb () {
        return getBookTicketElement("ArriveStation");
    }
    public WebElement getSeatTypeCbb () {
        return getBookTicketElement("SeatType");
    }
    public WebElement getTicketAmountCbb () {
        return getBookTicketElement("TicketAmount");
    }
    public WebElement getBtnBookTicket () {
        return Constant.WEBDRIVER.findElement(_btnBookTicket);
    }
    public WebElement getTableCell (int index) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format("//tr[@class='OddRow']//td[%s]", index)));
    }

    //Methods
    public boolean checkFormBookTicketDisplayed () {
        return isDisplayed(this.getFormBookTicket());
    }

    public TicketBookedSuccessPage bookTicket (Ticket ticket){
        select(getDepartDateCbb(), ticket.getDepartDate().format(DateTimeFormatter.ofPattern("M/d/yyyy")));
        select(getDepartFromCbb(), ticket.getDepartFrom());

        waitForElementStaleness(getArriveAtCbb());
        select(getArriveAtCbb(), ticket.getArriveAt());

        select(getSeatTypeCbb(), ticket.getSeatType());
        select(getTicketAmountCbb(), String.valueOf(ticket.getTicketAmount()));
        getBtnBookTicket().submit();
        return new TicketBookedSuccessPage ();

    }
    public String getTableInformation (int index) {
        return this.getTableCell(index).getText();
    }
}
