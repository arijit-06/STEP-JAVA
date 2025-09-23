// File: SuperMethodCallsDemo.java
// LAB 6: Box and Gift Box Enhancement

public class SuperMethodCallsDemo {
    
    public static class Box {
        protected double length;
        protected double width;
        protected double height;
        protected String material;
        
        public Box(double length, double width, double height, String material) {
            this.length = length;
            this.width = width;
            this.height = height;
            this.material = material;
        }
        
        public void pack() {
            System.out.println("Packing items in " + material + " box");
            System.out.println("Box dimensions: " + length + "x" + width + "x" + height);
        }
        
        public void unpack() {
            System.out.println("Unpacking " + material + " box");
            System.out.println("Removing items carefully");
        }
        
        public double calculateVolume() {
            return length * width * height;
        }
        
        public void displayInfo() {
            System.out.println("Box: " + length + "x" + width + "x" + height + 
                             " (" + material + ") - Volume: " + calculateVolume());
        }
    }
    
    public static class GiftBox extends Box {
        private String wrapperColor;
        private String ribbonType;
        private boolean hasCard;
        
        public GiftBox(double length, double width, double height, 
                      String wrapperColor, String ribbonType, boolean hasCard) {
            super(length, width, height, "Cardboard");
            this.wrapperColor = wrapperColor;
            this.ribbonType = ribbonType;
            this.hasCard = hasCard;
        }
        
        @Override
        public void pack() {
            super.pack(); // Call parent's pack method first
            System.out.println("Wrapping with " + wrapperColor + " paper");
            System.out.println("Adding " + ribbonType + " ribbon");
            if (hasCard) {
                System.out.println("Attaching greeting card");
            }
            System.out.println("Gift box ready for presentation!");
        }
        
        @Override
        public void unpack() {
            System.out.println("Carefully removing " + ribbonType + " ribbon");
            System.out.println("Unwrapping " + wrapperColor + " paper");
            if (hasCard) {
                System.out.println("Reading the greeting card");
            }
            super.unpack(); // Call parent's unpack method after gift-specific steps
            System.out.println("Gift successfully unwrapped!");
        }
        
        @Override
        public void displayInfo() {
            super.displayInfo(); // Call parent's display method
            System.out.println("Gift details - Wrapper: " + wrapperColor + 
                             ", Ribbon: " + ribbonType + ", Card: " + (hasCard ? "Yes" : "No"));
        }
        
        public void addGreetingCard(String message) {
            hasCard = true;
            System.out.println("Adding greeting card with message: \"" + message + "\"");
        }
        
        public void changeRibbon(String newRibbonType) {
            System.out.println("Changing ribbon from " + ribbonType + " to " + newRibbonType);
            this.ribbonType = newRibbonType;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Super Method Calls Demo ===");
        
        Box regularBox = new Box(10, 8, 6, "Plastic");
        GiftBox birthdayGift = new GiftBox(12, 10, 8, "Blue", "Silk", false);
        
        System.out.println("\n=== Regular Box Operations ===");
        regularBox.displayInfo();
        regularBox.pack();
        regularBox.unpack();
        
        System.out.println("\n=== Gift Box Operations ===");
        birthdayGift.displayInfo();
        birthdayGift.addGreetingCard("Happy Birthday!");
        birthdayGift.pack();
        
        System.out.println("\n=== Gift Box Unpacking ===");
        birthdayGift.unpack();
        
        System.out.println("\n=== Customizing Gift Box ===");
        birthdayGift.changeRibbon("Satin");
        birthdayGift.displayInfo();
        
        System.out.println("\n=== Polymorphism with Super Calls ===");
        Box polymorphicGift = new GiftBox(15, 12, 10, "Red", "Velvet", true);
        polymorphicGift.displayInfo(); // Calls overridden method which uses super
        polymorphicGift.pack(); // Calls overridden method which uses super
    }
}