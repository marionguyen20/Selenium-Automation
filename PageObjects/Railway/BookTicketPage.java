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
    public WebElement getContainSelectionBox (String field, String contain) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format("//form//select[@name='%s']//option[contains(text(), '%s')]", field, contain)));
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
    public void selectContainSelectionBox (String field, String contain) {
        this.getContainSelectionBox(field, contain).click();
    }
    public BookTicketPage bookTicket (String departDate, String depart, String arrive, String seatType, int ticketAmount){
        if (!departDate.equals("")) selectContainSelectionBox("Date", departDate);
        if (!departDate.equals("")) selectContainSelectionBox("DepartStation", depart);
        if (!departDate.equals("")) selectContainSelectionBox("ArriveStation", arrive);
        if (!departDate.equals("")) selectContainSelectionBox("SeatType", seatType);
        if (!departDate.equals("")) selectContainSelectionBox("TicketAmount", String.valueOf(ticketAmount));
        this.getBtnBookTicket().submit();
        return this;
    }
    public String getTableInformation (int index) {
        return this.getTableCell(index).getText();
    }
}
