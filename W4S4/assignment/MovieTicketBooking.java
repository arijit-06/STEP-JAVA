import java.util.Scanner;

class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;
    
    // Default constructor
    public MovieTicket() {
        this.movieName = "Unknown";
        this.theatreName = "Default Theatre";
        this.seatNumber = 1;
        this.price = 150.0;
    }
    
    // Constructor with movie name
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.theatreName = "Default Theatre";
        this.seatNumber = 1;
        this.price = 200.0;
    }
    
    // Constructor with movie name and seat number
    public MovieTicket(String movieName, int seatNumber) {
        this.movieName = movieName;
        this.theatreName = "PVR";
        this.seatNumber = seatNumber;
        this.price = 200.0;
    }
    
    // Full constructor
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }
    
    public void printTicket() {
        System.out.println("🎬 MOVIE TICKET 🎬");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Price: ₹" + price);
        System.out.println("-------------------");
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== MOVIE TICKET BOOKING SYSTEM ===\n");
        
        // Default ticket
        MovieTicket ticket1 = new MovieTicket();
        System.out.println("Default Ticket:");
        ticket1.printTicket();
        
        // Movie name only
        MovieTicket ticket2 = new MovieTicket("Avengers");
        System.out.println("Movie Name Only:");
        ticket2.printTicket();
        
        // Movie and seat
        MovieTicket ticket3 = new MovieTicket("Spider-Man", 15);
        System.out.println("Movie and Seat:");
        ticket3.printTicket();
        
        // Full details
        MovieTicket ticket4 = new MovieTicket("Batman", "INOX", 25, 350.0);
        System.out.println("Full Details:");
        ticket4.printTicket();
        
        sc.close();
    }
}