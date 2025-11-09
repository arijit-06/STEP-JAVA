enum TicketState {
    CREATED, BOOKED, CONFIRMED, CANCELLED, EXPIRED
}

class Ticket {
    private String ticketId;
    private TicketState state;
    private String eventName;
    
    public Ticket(String ticketId, String eventName) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.state = TicketState.CREATED;
        System.out.println("Ticket " + ticketId + " CREATED for " + eventName);
    }
    
    public void bookTicket() {
        if (state == TicketState.CREATED) {
            state = TicketState.BOOKED;
            System.out.println("Ticket " + ticketId + " -> BOOKED (event: userSelection)");
        } else {
            System.out.println("Cannot book ticket in " + state + " state");
        }
    }
    
    public void confirmPayment() {
        if (state == TicketState.BOOKED) {
            state = TicketState.CONFIRMED;
            System.out.println("Ticket " + ticketId + " -> CONFIRMED (event: paymentSuccess)");
        } else {
            System.out.println("Cannot confirm ticket in " + state + " state");
        }
    }
    
    public void cancelTicket() {
        if (state == TicketState.BOOKED || state == TicketState.CONFIRMED) {
            state = TicketState.CANCELLED;
            System.out.println("Ticket " + ticketId + " -> CANCELLED (event: userCancel)");
        } else {
            System.out.println("Cannot cancel ticket in " + state + " state");
        }
    }
    
    public void expireTicket() {
        if (state == TicketState.BOOKED) {
            state = TicketState.EXPIRED;
            System.out.println("Ticket " + ticketId + " -> EXPIRED (event: timeout)");
        } else {
            System.out.println("Cannot expire ticket in " + state + " state");
        }
    }
    
    public void showState() {
        System.out.println("Current state: " + state);
    }
}

public class TicketLifecycle {
    public static void main(String[] args) {
        System.out.println("State Diagram - Ticket Lifecycle:");
        
        Ticket ticket1 = new Ticket("TKT001", "Concert");
        ticket1.bookTicket();
        ticket1.confirmPayment();
        ticket1.showState();
        
        System.out.println();
        
        Ticket ticket2 = new Ticket("TKT002", "Movie");
        ticket2.bookTicket();
        ticket2.expireTicket();
        ticket2.showState();
        
        System.out.println();
        
        Ticket ticket3 = new Ticket("TKT003", "Sports");
        ticket3.bookTicket();
        ticket3.cancelTicket();
        ticket3.showState();
    }
}