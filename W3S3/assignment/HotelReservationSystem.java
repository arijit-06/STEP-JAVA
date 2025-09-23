class Room {
    private String roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int maxOccupancy;
    
    public Room(String roomNumber, String roomType, double pricePerNight, int maxOccupancy) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.maxOccupancy = maxOccupancy;
        this.isAvailable = true;
    }
    
    public void displayRoom() {
        System.out.println("Room " + roomNumber + " (" + roomType + ") - $" + pricePerNight + 
                          "/night, Max: " + maxOccupancy + " - " + 
                          (isAvailable ? "Available" : "Occupied"));
    }
    
    public String getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
    public int getMaxOccupancy() { return maxOccupancy; }
}

class Guest {
    private String guestId;
    private String guestName;
    private String phoneNumber;
    private String email;
    private String[] bookingHistory;
    private int bookingCount;
    private static int totalGuests = 0;
    
    public Guest(String guestName, String phoneNumber, String email) {
        this.guestId = generateGuestId();
        this.guestName = guestName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookingHistory = new String[10];
        this.bookingCount = 0;
        totalGuests++;
    }
    
    private static String generateGuestId() {
        return "G" + String.format("%03d", totalGuests + 1);
    }
    
    public void addBooking(String bookingId) {
        if (bookingCount < bookingHistory.length) {
            bookingHistory[bookingCount] = bookingId;
            bookingCount++;
        }
    }
    
    public void displayGuest() {
        System.out.println("Guest: " + guestName + " (" + guestId + ")");
        System.out.println("Contact: " + phoneNumber + ", " + email);
        System.out.println("Bookings: " + bookingCount);
    }
    
    public String getGuestId() { return guestId; }
    public String getGuestName() { return guestName; }
    public static int getTotalGuests() { return totalGuests; }
}

class Booking {
    private String bookingId;
    private Guest guest;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;
    
    private static int totalBookings = 0;
    private static double hotelRevenue = 0;
    private static String hotelName = "Grand Hotel";
    
    public Booking(Guest guest, Room room, String checkInDate, String checkOutDate, int nights) {
        this.bookingId = generateBookingId();
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = room.getPricePerNight() * nights;
        
        totalBookings++;
        hotelRevenue += totalAmount;
        room.setAvailable(false);
        guest.addBooking(bookingId);
    }
    
    private static String generateBookingId() {
        return "BK" + String.format("%04d", totalBookings + 1);
    }
    
    public static void setHotelName(String name) {
        hotelName = name;
    }
    
    public static int getTotalBookings() { return totalBookings; }
    public static double getHotelRevenue() { return hotelRevenue; }
    
    public static double getOccupancyRate(Room[] rooms) {
        int occupied = 0;
        for (Room r : rooms) {
            if (r != null && !r.isAvailable()) occupied++;
        }
        return rooms.length > 0 ? (double) occupied / rooms.length * 100 : 0;
    }
    
    public static String getMostPopularRoomType(Room[] rooms) {
        int single = 0, double_ = 0, suite = 0;
        for (Room r : rooms) {
            if (r != null && !r.isAvailable()) {
                switch (r.getRoomType()) {
                    case "Single": single++; break;
                    case "Double": double_++; break;
                    case "Suite": suite++; break;
                }
            }
        }
        
        if (single >= double_ && single >= suite) return "Single";
        else if (double_ >= suite) return "Double";
        else return "Suite";
    }
    
    public void displayBooking() {
        System.out.println("=== Booking Details ===");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest: " + guest.getGuestName());
        System.out.println("Room: " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("=======================");
    }
    
    public void cancelReservation() {
        room.setAvailable(true);
        hotelRevenue -= totalAmount;
        System.out.println("Booking " + bookingId + " cancelled");
    }
    
    public String getBookingId() { return bookingId; }
    public double getTotalAmount() { return totalAmount; }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Booking.setHotelName("Grand Paradise Hotel");
        
        // Initialize rooms
        Room[] rooms = {
            new Room("101", "Single", 80.0, 1),
            new Room("102", "Single", 80.0, 1),
            new Room("201", "Double", 120.0, 2),
            new Room("202", "Double", 120.0, 2),
            new Room("301", "Suite", 200.0, 4),
            new Room("302", "Suite", 200.0, 4),
            new Room("103", "Single", 80.0, 1),
            new Room("203", "Double", 120.0, 2)
        };
        
        // Create guests
        Guest guest1 = new Guest("John Smith", "555-0101", "john@email.com");
        Guest guest2 = new Guest("Jane Doe", "555-0102", "jane@email.com");
        Guest guest3 = new Guest("Bob Johnson", "555-0103", "bob@email.com");
        Guest guest4 = new Guest("Alice Brown", "555-0104", "alice@email.com");
        
        System.out.println("=== Hotel Reservation System ===");
        System.out.println("Hotel: Grand Paradise Hotel");
        System.out.println("Total Rooms: " + rooms.length);
        System.out.println("Total Guests: " + Guest.getTotalGuests());
        
        System.out.println("\n=== Available Rooms ===");
        for (Room room : rooms) {
            room.displayRoom();
        }
        
        System.out.println("\n=== Making Reservations ===");
        Booking booking1 = new Booking(guest1, rooms[0], "2024-01-15", "2024-01-18", 3);
        booking1.displayBooking();
        
        Booking booking2 = new Booking(guest2, rooms[2], "2024-01-20", "2024-01-25", 5);
        booking2.displayBooking();
        
        Booking booking3 = new Booking(guest3, rooms[4], "2024-01-22", "2024-01-24", 2);
        booking3.displayBooking();
        
        Booking booking4 = new Booking(guest4, rooms[1], "2024-01-25", "2024-01-27", 2);
        booking4.displayBooking();
        
        System.out.println("\n=== Updated Room Status ===");
        for (Room room : rooms) {
            room.displayRoom();
        }
        
        System.out.println("\n=== Hotel Statistics ===");
        System.out.println("Total Bookings: " + Booking.getTotalBookings());
        System.out.println("Total Revenue: $" + Booking.getHotelRevenue());
        System.out.println("Occupancy Rate: " + Booking.getOccupancyRate(rooms) + "%");
        System.out.println("Most Popular Room Type: " + Booking.getMostPopularRoomType(rooms));
        
        System.out.println("\n=== Guest Information ===");
        Guest[] guests = {guest1, guest2, guest3, guest4};
        for (Guest guest : guests) {
            guest.displayGuest();
            System.out.println();
        }
        
        System.out.println("=== Cancellation Demo ===");
        booking2.cancelReservation();
        
        System.out.println("\n=== Updated Statistics After Cancellation ===");
        System.out.println("Total Revenue: $" + Booking.getHotelRevenue());
        System.out.println("Occupancy Rate: " + Booking.getOccupancyRate(rooms) + "%");
        
        System.out.println("\n=== Room Type Analysis ===");
        int singleRooms = 0, doubleRooms = 0, suiteRooms = 0;
        double singleRevenue = 0, doubleRevenue = 0, suiteRevenue = 0;
        
        for (Room room : rooms) {
            switch (room.getRoomType()) {
                case "Single":
                    singleRooms++;
                    if (!room.isAvailable()) singleRevenue += room.getPricePerNight();
                    break;
                case "Double":
                    doubleRooms++;
                    if (!room.isAvailable()) doubleRevenue += room.getPricePerNight();
                    break;
                case "Suite":
                    suiteRooms++;
                    if (!room.isAvailable()) suiteRevenue += room.getPricePerNight();
                    break;
            }
        }
        
        System.out.println("Single Rooms: " + singleRooms + " (Revenue: $" + singleRevenue + ")");
        System.out.println("Double Rooms: " + doubleRooms + " (Revenue: $" + doubleRevenue + ")");
        System.out.println("Suite Rooms: " + suiteRooms + " (Revenue: $" + suiteRevenue + ")");
        
        System.out.println("\n=== Object Interactions Demonstrated ===");
        System.out.println("✓ Booking objects link Guest and Room objects");
        System.out.println("✓ Room availability updated through Booking");
        System.out.println("✓ Guest booking history maintained automatically");
        System.out.println("✓ Static methods provide hotel-wide statistics");
    }
}