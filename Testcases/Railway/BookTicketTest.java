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
        BookTicketPage bookTicketPage = homePage
                .open()
                .gotoLoginPage()
                .loginSucessToHomePage(Constant.DEFAULT_ACCOUNT)
                .gotoBookTicketPageLogin();

        String depart = "Nha Trang";
        String arrive = "Sài Gòn";
        String seatType = "Soft seat with air conditioner";
        int ticketAmount = 5;
        bookTicketPage.bookTicket("",depart, arrive, seatType, ticketAmount);

        Assert.assertEquals(bookTicketPage.getPageTitle(), "Ticket booked successfully!");
        Assert.assertEquals(bookTicketPage.getTableInformation(2), depart);
        Assert.assertEquals(bookTicketPage.getTableInformation(3), arrive);
        Assert.assertEquals(bookTicketPage.getTableInformation(4), seatType);
        Assert.assertEquals(bookTicketPage.getTableInformation(5), String.valueOf(ticketAmount));

    }
}
