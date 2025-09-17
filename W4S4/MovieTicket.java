public class MovieTicket {
    private String movieName;
    private String theatreName;
    private int seatNumber;
    private double price;
    
    public MovieTicket() {
        this.movieName = "Unknown";
    }
    
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.price = 200;
    }
    
    public MovieTicket(String movieName, int seatNumber) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.theatreName = "PVR";
    }
    
    public MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }
    
    public void printTicket() {
        System.out.println("Movie: " + movieName + ", Theatre: " + theatreName + 
                          ", Seat: " + seatNumber + ", Price: " + price);
    }
    
    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Avengers");
        MovieTicket t3 = new MovieTicket("Spider-Man", 15);
        MovieTicket t4 = new MovieTicket("Batman", "INOX", 25, 300);
        
        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}