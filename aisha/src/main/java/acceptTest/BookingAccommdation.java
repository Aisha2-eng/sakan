package acceptTest;

import java.util.ArrayList;
import java.util.List;

public class BookingAccommdation {

    private List<BookingInfo> bookings;

    public BookingAccommdation() {
        bookings = new ArrayList<>();
    }

    public void bookAccommodation(String housingUnitName, String dates, String duration, String name, String email) {
        BookingInfo bookingInfo = new BookingInfo(housingUnitName, dates, duration, name, email);
        bookings.add(bookingInfo);
        // Implement the logic to send a confirmation email
        sendConfirmationEmail(bookingInfo);
    }

    private void sendConfirmationEmail(BookingInfo bookingInfo) {
        // Implement the logic to send a confirmation email
        // This is a placeholder implementation and will just print the email details to the console.
        System.out.println("Confirmation Email Sent to: " + bookingInfo.email);
        System.out.println("Booking Details:");
        System.out.println("Housing Unit: " + bookingInfo.housingUnitName);
        System.out.println("Dates: " + bookingInfo.dates);
        System.out.println("Duration: " + bookingInfo.duration);
        System.out.println("Name: " + bookingInfo.name);
    }

    public List<BookingInfo> getBookings() {
        return bookings;
    }

    public static class BookingInfo {
        public String housingUnitName;
        public String dates;
        public String duration;
        public String name;
        public String email;

        public BookingInfo(String housingUnitName, String dates, String duration, String name, String email) {
            this.housingUnitName = housingUnitName;
            this.dates = dates;
            this.duration = duration;
            this.name = name;
            this.email = email;
        }
    }
}
