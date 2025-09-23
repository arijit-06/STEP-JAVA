// File: PolymorphismDemo.java
// LAB 3: Bird Flying Behavior

public class PolymorphismDemo {
    
    public static class Bird {
        protected String species;
        protected String habitat;
        
        public Bird(String species, String habitat) {
            this.species = species;
            this.habitat = habitat;
        }
        
        public void fly() {
            System.out.println(species + " is flying");
        }
        
        public void eat() {
            System.out.println(species + " is eating");
        }
        
        public void displayInfo() {
            System.out.println(species + " lives in " + habitat);
        }
    }
    
    public static class Penguin extends Bird {
        public Penguin() {
            super("Penguin", "Antarctica");
        }
        
        @Override
        public void fly() {
            System.out.println("Penguin cannot fly, but swims excellently!");
        }
        
        public void swim() {
            System.out.println("Penguin is swimming gracefully");
        }
    }
    
    public static class Eagle extends Bird {
        private double wingspan;
        
        public Eagle(double wingspan) {
            super("Eagle", "Mountains");
            this.wingspan = wingspan;
        }
        
        @Override
        public void fly() {
            System.out.println("Eagle soars high with " + wingspan + "m wingspan");
        }
        
        public void hunt() {
            System.out.println("Eagle is hunting prey");
        }
    }
    
    public static class Sparrow extends Bird {
        public Sparrow() {
            super("Sparrow", "Urban areas");
        }
        
        @Override
        public void fly() {
            System.out.println("Sparrow flies quickly in short bursts");
        }
        
        public void chirp() {
            System.out.println("Sparrow is chirping melodiously");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Polymorphism Demo ===");
        
        Bird[] birds = {
            new Penguin(),
            new Eagle(2.5),
            new Sparrow(),
            new Eagle(3.0)
        };
        
        System.out.println("\n=== Polymorphic Method Calls ===");
        for (Bird bird : birds) {
            bird.displayInfo();
            bird.fly(); // Different implementation for each subclass
            bird.eat();
            System.out.println();
        }
        
        System.out.println("=== Type-specific Methods ===");
        for (Bird bird : birds) {
            if (bird instanceof Penguin) {
                ((Penguin) bird).swim();
            } else if (bird instanceof Eagle) {
                ((Eagle) bird).hunt();
            } else if (bird instanceof Sparrow) {
                ((Sparrow) bird).chirp();
            }
        }
    }
}