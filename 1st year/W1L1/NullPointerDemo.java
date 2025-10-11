/*
Level 1 Practice Program 4: NullPointerException demonstration
*/

public class NullPointerDemo {
    
    public static void generateException() {
        String text = null;
        System.out.println("Length: " + text.length()); // This will throw NullPointerException
    }
    
    public static void handleException() {
        String text = null;
        try {
            System.out.println("Length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Generating NullPointerException ===");
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Exception in main: " + e.getClass().getSimpleName());
        }
        
        System.out.println("\n=== Handling NullPointerException ===");
        handleException();
    }
}