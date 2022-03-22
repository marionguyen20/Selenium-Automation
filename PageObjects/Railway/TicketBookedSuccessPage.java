package Railway;

public class TicketBookedSuccessPage extends GeneralPage {
   
   String tableCellXpath = "//table//tr/td[count(//table//tr/th[text()='%s']/preceding-sibling::th)+1]";

   private WebElement getCellElement (String header) {
       return Constant.WEBDRIVER.findElement(By.xpath(String.format(tableCellXpath, header)));
   }

   public String getDepartStationValue() {
       return getCellElement("Depart Station").getText();
   }
   public String getArriveStationValue () {
       return getCellElement("Arrive Station").getText();
   }
   public String getSeatTypeValue () {
       return getCellElement("Seat Type").getText();
   }
   public String getDepartDateValue () {
       return getCellElement("Depart Date").getText();
   }
   public int getAmountValue () {
       return Integer.parseInt(getCellElement("Amount").getText());
   }

   public Ticket getBookedTicket(){
       Ticket ticket = new Ticket (
           getDepartDateValue(),
           getDepartStationValue(),
           getArriveStationValue(),
           getSeatTypeValue(),
           getAmountValue()
       );
       return ticket;
   }

    
}