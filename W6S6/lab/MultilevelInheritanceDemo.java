// File: MultilevelInheritanceDemo.java
// LAB 4: Color Hierarchy Chain

public class MultilevelInheritanceDemo {
    
    public static class Color {
        protected String name;
        protected String hexCode;
        
        public Color(String name, String hexCode) {
            this.name = name;
            this.hexCode = hexCode;
            System.out.println("Color constructor: " + name);
        }
        
        public void display() {
            System.out.println("Color: " + name + " (" + hexCode + ")");
        }
        
        public void mix() {
            System.out.println("Mixing " + name + " color");
        }
    }
    
    public static class PrimaryColor extends Color {
        protected int intensity;
        
        public PrimaryColor(String name, String hexCode, int intensity) {
            super(name, hexCode);
            this.intensity = intensity;
            System.out.println("PrimaryColor constructor: intensity " + intensity);
        }
        
        @Override
        public void display() {
            super.display();
            System.out.println("Intensity: " + intensity + "%");
        }
        
        public void adjustIntensity(int newIntensity) {
            this.intensity = newIntensity;
            System.out.println("Intensity adjusted to " + intensity + "%");
        }
    }
    
    public static class RedColor extends PrimaryColor {
        private String shade;
        
        public RedColor(String shade, int intensity) {
            super("Red", "#FF0000", intensity);
            this.shade = shade;
            System.out.println("RedColor constructor: " + shade + " shade");
        }
        
        @Override
        public void display() {
            super.display();
            System.out.println("Shade: " + shade);
        }
        
        @Override
        public void mix() {
            super.mix();
            System.out.println("Creating " + shade + " red mixture");
        }
        
        public void createWarmTone() {
            System.out.println("Creating warm " + shade + " red tone");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Multilevel Inheritance Demo ===");
        
        RedColor crimson = new RedColor("Crimson", 85);
        
        System.out.println("\n=== Testing Methods ===");
        crimson.display();
        crimson.mix();
        crimson.adjustIntensity(90);
        crimson.createWarmTone();
        
        System.out.println("\n=== Polymorphism Test ===");
        Color color = new RedColor("Scarlet", 75);
        color.display();
        color.mix();
    }
}