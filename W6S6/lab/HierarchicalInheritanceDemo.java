// File: HierarchicalInheritanceDemo.java
// LAB 5: Musical Instrument Family

public class HierarchicalInheritanceDemo {
    
    public static class Instrument {
        protected String name;
        protected String material;
        protected double price;
        
        public Instrument(String name, String material, double price) {
            this.name = name;
            this.material = material;
            this.price = price;
        }
        
        public void play() {
            System.out.println("Playing the " + name);
        }
        
        public void tune() {
            System.out.println("Tuning the " + name);
        }
        
        public void displayInfo() {
            System.out.println(name + " - Material: " + material + ", Price: $" + price);
        }
    }
    
    public static class Piano extends Instrument {
        private int keys;
        private String type;
        
        public Piano(String type, int keys, double price) {
            super("Piano", "Wood/Metal", price);
            this.type = type;
            this.keys = keys;
        }
        
        @Override
        public void play() {
            System.out.println("Playing beautiful melodies on " + keys + "-key " + type + " piano");
        }
        
        @Override
        public void tune() {
            System.out.println("Professional piano tuner adjusting " + keys + " keys");
        }
        
        public void playChord() {
            System.out.println("Playing harmonious chord on piano");
        }
    }
    
    public static class Guitar extends Instrument {
        private int strings;
        private String guitarType;
        
        public Guitar(String guitarType, int strings, double price) {
            super("Guitar", "Wood", price);
            this.guitarType = guitarType;
            this.strings = strings;
        }
        
        @Override
        public void play() {
            System.out.println("Strumming the " + strings + "-string " + guitarType + " guitar");
        }
        
        @Override
        public void tune() {
            System.out.println("Tuning " + strings + " strings of the guitar");
        }
        
        public void strum() {
            System.out.println("Strumming guitar strings rhythmically");
        }
    }
    
    public static class Drum extends Instrument {
        private String drumType;
        private double diameter;
        
        public Drum(String drumType, double diameter, double price) {
            super("Drum", "Wood/Plastic", price);
            this.drumType = drumType;
            this.diameter = diameter;
        }
        
        @Override
        public void play() {
            System.out.println("Beating the " + diameter + "\" " + drumType + " drum");
        }
        
        @Override
        public void tune() {
            System.out.println("Adjusting tension of " + drumType + " drum head");
        }
        
        public void roll() {
            System.out.println("Performing drum roll on " + drumType);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Hierarchical Inheritance Demo ===");
        
        Instrument[] orchestra = {
            new Piano("Grand", 88, 15000),
            new Guitar("Acoustic", 6, 800),
            new Drum("Snare", 14, 300),
            new Guitar("Electric", 6, 1200)
        };
        
        System.out.println("\n=== Orchestra Information ===");
        for (Instrument instrument : orchestra) {
            instrument.displayInfo();
        }
        
        System.out.println("\n=== Tuning Session ===");
        for (Instrument instrument : orchestra) {
            instrument.tune();
        }
        
        System.out.println("\n=== Performance ===");
        for (Instrument instrument : orchestra) {
            instrument.play();
        }
        
        System.out.println("\n=== Special Techniques ===");
        for (Instrument instrument : orchestra) {
            if (instrument instanceof Piano) {
                ((Piano) instrument).playChord();
            } else if (instrument instanceof Guitar) {
                ((Guitar) instrument).strum();
            } else if (instrument instanceof Drum) {
                ((Drum) instrument).roll();
            }
        }
    }
}