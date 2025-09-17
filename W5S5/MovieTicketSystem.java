// Movie Ticket Booking System - Assignment Problem 1
import java.util.*;

class Movie {
    private String title;
    private String genre;
    private int duration;
    private double rating;
    private double ticketPrice;
    
    // Constructor with title only
    public Movie(String title) {
        this(title, "General", 120, 7.0, 12.0);
    }
    
    // Constructor with title and genre
    public Movie(String title, String genre) {
        this(title, genre, 120, 7.0, 15.0);
    }
    
    // Full constructor
    public Movie(String title, String genre, int duration, double rating, double ticketPrice) {
        this.title = (title != null && !title.trim().isEmpty()) ? title : "Unknown Movie";
        this.genre = (genre != null) ? genre : "General";
        this.duration = (duration > 0) ? duration : 120;
        this.rating = Math.max(0, Math.min(10, rating));
        this.ticketPrice = (ticketPrice > 0) ? ticketPrice : 10.0;
    }
    
    public void displayMovieInfo() {
        System.out.println("Movie: " + title + " (" + genre + ")");
        System.out.println("Duration: " + duration + " minutes, Rating: " + rating + "/10");
        System.out.println("Ticket Price: $" + ticketPrice);
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getDuration() { return duration; }
    public double getRating() { return rating; }
    public double getTicketPrice() { return ticketPrice; }
}

class Ticket {
    private static int ticketCounter = 0;
    
    private String ticketId;
    private String movieTitle;
    private String customerName;
    private String seatNumber;
    private String ticketType;
    private double price;
    private String showTime;
    
    // Basic ticket constructor
    public Ticket(String movieTitle, String customerName) {
        this(movieTitle, customerName, "Standard", "A" + (ticketCounter % 20 + 1), "7:00 PM");
    }
    
    // Constructor with ticket type
    public Ticket(String movieTitle, String customerName, String ticketType) {
        this(movieTitle, customerName, ticketType, "A" + (ticketCounter % 20 + 1), "7:00 PM");
    }
    
    // Full constructor - constructor chaining
    public Ticket(String movieTitle, String customerName, String ticketType, String seatNumber, String showTime) {
        this.ticketId = "TKT" + String.format("%04d", ++ticketCounter);
        this.movieTitle = movieTitle;
        this.customerName = customerName;
        this.ticketType = ticketType;
        this.seatNumber = seatNumber;
        this.showTime = showTime;
        this.price = calculatePrice(ticketType);
    }
    
    private double calculatePrice(String ticketType) {
        switch (ticketType.toLowerCase()) {
            case "premium": return 20.0;
            case "vip": return 25.0;
            case "student": return 8.0;
            case "senior": return 10.0;
            default: return 15.0; // Standard
        }
    }
    
    public void displayTicket() {
        System.out.println("\n=== TICKET ===");
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Movie: " + movieTitle);
        System.out.println("Customer: " + customerName);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Type: " + ticketType);
        System.out.println("Show Time: " + showTime);
        System.out.println("Price: $" + price);
        System.out.println("==============");
    }
    
    // Getters
    public String getTicketId() { return ticketId; }
    public String getMovieTitle() { return movieTitle; }
    public String getCustomerName() { return customerName; }
    public String getTicketType() { return ticketType; }
    public double getPrice() { return price; }
    
    public static int getTotalTicketsSold() {
        return ticketCounter;
    }
}

class Customer {
    private String customerId;
    private String name;
    private String email;
    private String membershipType;
    private List<String> bookingHistory;
    
    public Customer(String name, String email) {
        this(name, email, "Regular");
    }
    
    public Customer(String name, String email, String membershipType) {
        this.customerId = "CUST" + String.format("%03d", new Random().nextInt(1000));
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
        this.bookingHistory = new ArrayList<>();
    }
    
    // Method chaining using 'this'
    public Customer updateEmail(String email) {
        this.email = email;
        return this;
    }
    
    public Customer upgradeMembership(String newType) {
        this.membershipType = newType;
        System.out.println(this.name + " upgraded to " + newType + " membership");
        return this;
    }
    
    public Customer addBooking(String movieTitle) {
        this.bookingHistory.add(movieTitle);
        return this;
    }
    
    public void displayProfile() {
        System.out.println("\n=== Customer Profile ===");
        System.out.println("ID: " + this.customerId);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Membership: " + this.membershipType);
        System.out.println("Bookings: " + this.bookingHistory.size());
    }
    
    // Getters
    public String getName() { return name; }
    public String getMembershipType() { return membershipType; }
    public List<String> getBookingHistory() { return new ArrayList<>(bookingHistory); }
}

class TheaterSystem {
    // Static fields for theater-wide statistics
    private static double totalRevenue = 0.0;
    private static int totalBookings = 0;
    private static Map<String, Integer> genrePopularity = new HashMap<>();
    
    private List<Object> customers; // Mixed object storage
    private List<Movie> movies;
    private List<Ticket> tickets;
    
    public TheaterSystem() {
        this.customers = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
    
    public void addCustomer(Object customer) {
        if (customer instanceof Customer) {
            customers.add(customer);
            Customer c = (Customer) customer;
            System.out.println("Customer " + c.getName() + " registered");
        } else {
            System.out.println("Error: Invalid customer object");
        }
    }
    
    public void addMovie(Movie movie) {
        movies.add(movie);
        genrePopularity.put(movie.getGenre(), genrePopularity.getOrDefault(movie.getGenre(), 0));
        System.out.println("Movie added: " + movie.getTitle());
    }
    
    // Method using instanceof for different customer types
    public Ticket bookTicket(Object customerObj, String movieTitle, String ticketType) {
        if (!(customerObj instanceof Customer)) {
            System.out.println("Error: Invalid customer");
            return null;
        }
        
        Customer customer = (Customer) customerObj;
        
        // Apply membership discounts based on type
        String finalTicketType = ticketType;
        if (customer.getMembershipType().equals("Premium")) {
            finalTicketType = "Premium";
        } else if (customer.getMembershipType().equals("VIP")) {
            finalTicketType = "VIP";
        }
        
        Ticket ticket = new Ticket(movieTitle, customer.getName(), finalTicketType);
        tickets.add(ticket);
        customer.addBooking(movieTitle);
        
        // Update statistics
        totalRevenue += ticket.getPrice();
        totalBookings++;
        
        // Update genre popularity
        for (Movie movie : movies) {
            if (movie.getTitle().equals(movieTitle)) {
                String genre = movie.getGenre();
                genrePopularity.put(genre, genrePopularity.getOrDefault(genre, 0) + 1);
                break;
            }
        }
        
        System.out.println("Ticket booked successfully!");
        return ticket;
    }
    
    // Static methods for theater statistics
    public static void displayTheaterStats() {
        System.out.println("\n=== Theater Statistics ===");
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        System.out.println("Total Bookings: " + totalBookings);
        System.out.println("Total Tickets Sold: " + Ticket.getTotalTicketsSold());
        
        System.out.println("\nGenre Popularity:");
        for (Map.Entry<String, Integer> entry : genrePopularity.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " bookings");
        }
    }
    
    public static void resetStats() {
        totalRevenue = 0.0;
        totalBookings = 0;
        genrePopularity.clear();
        System.out.println("Theater statistics reset");
    }
    
    public void processCustomers() {
        System.out.println("\n=== Processing All Customers ===");
        for (Object obj : customers) {
            if (obj instanceof Customer) {
                Customer customer = (Customer) obj;
                System.out.println("Processing customer: " + customer.getName());
                
                // Different processing based on membership type
                String membershipType = customer.getMembershipType();
                switch (membershipType.toLowerCase()) {
                    case "vip":
                        System.out.println("  - VIP perks: Free popcorn, priority seating");
                        break;
                    case "premium":
                        System.out.println("  - Premium perks: Discounted tickets, early booking");
                        break;
                    default:
                        System.out.println("  - Standard service");
                }
            }
        }
    }
    
    public void displaySystemStatus() {
        System.out.println("\n=== System Status ===");
        System.out.println("Movies available: " + movies.size());
        System.out.println("Registered customers: " + customers.size());
        System.out.println("Tickets sold: " + tickets.size());
    }
}

public class MovieTicketSystem {
    public static void main(String[] args) {
        System.out.println("=== Movie Ticket Booking System ===");
        
        // Create theater system
        TheaterSystem theater = new TheaterSystem();
        
        // Demonstrate movie constructor patterns
        Movie movie1 = new Movie("Avengers: Endgame");
        Movie movie2 = new Movie("The Lion King", "Animation");
        Movie movie3 = new Movie("Inception", "Sci-Fi", 148, 8.8, 18.0);
        
        theater.addMovie(movie1);
        theater.addMovie(movie2);
        theater.addMovie(movie3);
        
        // Display movie information
        System.out.println("\n=== Available Movies ===");
        movie1.displayMovieInfo();
        System.out.println();
        movie2.displayMovieInfo();
        System.out.println();
        movie3.displayMovieInfo();
        
        // Create customers with different constructor patterns
        Customer customer1 = new Customer("John Doe", "john@email.com");
        Customer customer2 = new Customer("Jane Smith", "jane@email.com", "Premium");
        Customer customer3 = new Customer("Bob Wilson", "bob@email.com", "VIP");
        
        // Demonstrate method chaining with 'this'
        customer1.updateEmail("john.doe@newemail.com")
                .upgradeMembership("Premium");
        
        // Add customers to theater system
        theater.addCustomer(customer1);
        theater.addCustomer(customer2);
        theater.addCustomer(customer3);
        theater.addCustomer("Invalid customer"); // This should fail
        
        // Book tickets demonstrating instanceof usage
        System.out.println("\n=== Booking Tickets ===");
        Ticket ticket1 = theater.bookTicket(customer1, "Avengers: Endgame", "Standard");
        ticket1.displayTicket();
        
        Ticket ticket2 = theater.bookTicket(customer2, "The Lion King", "Standard");
        ticket2.displayTicket();
        
        Ticket ticket3 = theater.bookTicket(customer3, "Inception", "Standard");
        ticket3.displayTicket();
        
        // More bookings
        theater.bookTicket(customer1, "The Lion King", "Student");
        theater.bookTicket(customer2, "Inception", "Premium");
        
        // Process customers using instanceof
        theater.processCustomers();
        
        // Display customer profiles
        customer1.displayProfile();
        customer2.displayProfile();
        customer3.displayProfile();
        
        // Display system and theater statistics
        theater.displaySystemStatus();
        TheaterSystem.displayTheaterStats();
        
        // Demonstrate static method usage
        System.out.println("\nTotal tickets sold globally: " + Ticket.getTotalTicketsSold());
        
        // Test instanceof with mixed objects
        System.out.println("\n=== instanceof Testing ===");
        Object[] objects = {customer1, "Not a customer", customer2, 123, customer3};
        
        for (Object obj : objects) {
            if (obj instanceof Customer) {
                Customer c = (Customer) obj;
                System.out.println("✓ " + c.getName() + " is a Customer");
            } else {
                System.out.println("✗ " + obj + " is not a Customer");
            }
        }
    }
}