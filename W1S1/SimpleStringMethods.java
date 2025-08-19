public class SimpleStringMethods {

    public static void main(String[] args) {

        String text = "Welcome to Java ";

        // INSPECTION

        System.out.println("Length: " + text.length());

        System.out.println("First 'a' at index: " + text.indexOf('a'));

        // EXTRACTION

        System.out.println("Substring(0, 7): '" + text.substring(0, 7) + "'");

        // MODIFICATION
        System.out.println("Trimmed: '" + text.trim() + "'");
        System.out.println("Uppercase: '" + text.toUpperCase() + "'");

        // COMPARISON
        String other = "Welcome to Java";
        System.out.println("EqualsIgnoreCase: " + text.trim().equalsIgnoreCase(other));

    }
}
