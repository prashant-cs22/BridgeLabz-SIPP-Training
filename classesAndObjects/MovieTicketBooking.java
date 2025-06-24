package classesAndObjects;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void updatePrice(double newPrice) {
        this.price = newPrice;
        System.out.println("Price updated successfully to ₹" + newPrice);
    }

    void displayTicket() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }
}

public class MovieTicketBooking {

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Bahubali", "C4", 350.0);
        
        System.out.println("Original Ticket:");
        ticket.displayTicket();
        
        ticket.updatePrice(400.0); // updating the price
        
        System.out.println("\nUpdated Ticket:");
        ticket.displayTicket();
    }
}
