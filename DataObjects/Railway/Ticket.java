package Railway;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import Utilities.Utilities;
import Utilities.DataHelper;
import Enum.Province;
import Enum.SeatType;

public class Ticket {
    LocalDate departDate;
    String departFrom;
    String arriveAt;
    String seatType;
    int ticketAmount;

    public Ticket () {
        this.departDate = Utilities.random(3, 30);
        Province depart = Province.random();
        this.departFrom = depart.getLocation();
        this.arriveAt = DataHelper.getArriveAt(depart).getLocation();
        this.seatType = SeatType.random().getValue();
        this.ticketAmount = new Random().nextInt(10) + 1;
    }
    public Ticket (LocalDate departDate,  Province departFrom, Province arriveAt, SeatType seatType, int ticketAmount) {
        this.departDate = departDate;
        this.departFrom = departFrom.getLocation();
        this.arriveAt = arriveAt.getLocation();
        this.seatType = seatType.getValue();
        this.ticketAmount = ticketAmount;
    }
    public Ticket (String departDate,  String departFrom, String arriveAt, String seatType, int ticketAmount) {
        this.departDate = LocalDate.parse(departDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
        this.departFrom = departFrom;
        this.arriveAt = arriveAt;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }
    public LocalDate getDepartDate () {
        return this.departDate;
    }
    public void setDepartDate (LocalDate departDate) {
        this.departDate = departDate;
    }
    public String getDepartFrom () {
        return this.departFrom;
    }
    public void setDepartFrom (String departFrom) {
        this.departFrom = departFrom;
    }
    public String getArriveAt () {
        return this.arriveAt;
    }
    public void setArriveAt (String arriveAt) {
        this.arriveAt = arriveAt;
    }
    public String getSeatType () {
        return this.seatType;
    }
    public void setSeatType (String seatType) {
        this.seatType = seatType;
    }
    public int getTicketAmount () {
        return this.ticketAmount;
    }
    public void setTicketAmount (int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }
    public String toString () {
        return "Ticket [departDate=" + departDate + ", departFrom = "+ departFrom + ", arriveAt= "+ arriveAt + ", seatType = " 
                + seatType + ", ticketAmount = " + ticketAmount + "]"; 
    }

}