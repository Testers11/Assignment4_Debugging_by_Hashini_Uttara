/**
 * @author Hashini
 * ITC-515 professional programming practice
 * Assignment 4 - Individual_Debugging
 * Hotel room booking
 * Test case
**/

import hotel.booking.BookingCTL;
import hotel.checkin.CheckinCTL;
import hotel.checkout.CheckoutCTL;
import hotel.credit.CreditCard;
import hotel.credit.CreditCardType;
import hotel.entities.Booking;
import hotel.entities.Guest;
import hotel.entities.Hotel;
import hotel.entities.Room;
import hotel.entities.RoomType;
import hotel.entities.ServiceCharge;
import hotel.entities.ServiceType;
import hotel.service.RecordServiceCTL;
import hotel.utils.IOUtils;
import java.util.Date;
import java.util.List;

public class TestCase {

    public static void main(String[] args) throws Exception {

        Guest guest = new Guest("Hashini", "Melbourne", 0450256093);
        Room room = new Room(101, RoomType.SINGLE);
        CreditCard creditcard = new CreditCard(CreditCardType.VISA, 2, 3);
        Booking booking = new Booking(guest, room, new Date(), 1, 2, creditcard);

        long confirmationNumber = booking.getConfirmationNumber();

        System.out.println("Booking is created now. Confirmation no is: " + confirmationNumber);
        
        booking.checkIn();
        System.out.println("Booking checked in!");
        
        booking.addServiceCharge(ServiceType.ROOM_SERVICE, 400);
        System.out.println("Service charge added 400.0");
        
        List<ServiceCharge> serivceTypeList = booking.getCharges();
        System.out.println("\nDisplay added service charges:");
        for (ServiceCharge serviceCharge : serivceTypeList) {
            System.out.println(serviceCharge.getType() + " : " + serviceCharge.getCost());
        }
        
    }
}
