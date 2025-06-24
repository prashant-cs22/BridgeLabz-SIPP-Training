package constructorsAndAccessSpecifiers;

class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    HotelBooking() {
    	this.guestName = "Guest";
    	this.roomType = "Standard";
    	this.nights = 1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    HotelBooking(HotelBooking original) {
        this(original.guestName, original.roomType, original.nights);
    }

    void displayDetails() {
        System.out.println("Guest Name: " + this.guestName);
        System.out.println("Room Type: " + this.roomType);
        System.out.println("Nights: " + this.nights);
    }
}

public class HotelBookingDetails {

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Govind", "Deluxe", 3);
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println("Booking 1 - ");
        booking1.displayDetails();
        System.out.println();

        System.out.println("Booking 2 - ");
        booking2.displayDetails();
        System.out.println();

        System.out.println("Booking 3 (Cloned) - ");
        booking3.displayDetails();
    }
}
