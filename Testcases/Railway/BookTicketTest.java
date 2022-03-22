package Railway;

import Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookTicketTest extends BaseTest {
    Account account;

    @BeforeMethod
    public void createAccount () throws InterruptedException {
        //Create new Account
        account= new Account ();
        createAndActivateAccount(account);
    }
    @Test(description = "User can book many tickets at a time")
    public void TC14 () {

        Ticket ticket = new Ticket(Utilities.random(3, 30), 
                Province.NHA_TRANG, 
                Province.PHAN_THIET, 
                eatType.SOFT_BED_WITH_AIR_CONDITIONER, 
                5);
        TicketBookedSuccessPage ticketBookedSuccessPage = homePage
                .open()
                .gotoLoginPage()
                .loginSucessToHomePage(account)
                .gotoBookTicketPageLogin()
                .bookTicket(ticket);

        Assert.assertEquals(ticketBookedSuccessPage.getPageTitle(), "Ticket booked successfully!");

        Assert.assertEquals(ticketBookedSuccessPage.getBookedTicket().toString(), ticket.toString());

    }
    @Test (description = " \"Ticket price \" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page")
    public void TC15 () {
        
    }
}
