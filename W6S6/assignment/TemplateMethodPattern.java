// File: TemplateMethodPattern.java
// ASSIGNMENT 4: Food Preparation Template

public class TemplateMethodPattern {
    
    public static abstract class Food {
        protected String name;
        protected int cookingTime;
        
        public Food(String name, int cookingTime) {
            this.name = name;
            this.cookingTime = cookingTime;
        }
        
        // Template method - defines the algorithm structure
        public final void prepare() {
            System.out.println("=== Preparing " + name + " ===");
            wash();
            cook();
            serve();
            System.out.println(name + " is ready!\n");
        }
        
        // Abstract methods to be implemented by subclasses
        protected abstract void wash();
        protected abstract void cook();
        
        // Common method with default implementation
        protected void serve() {
            System.out.println("Serving " + name + " on a plate");
        }
    }
    
    public static class Pizza extends Food {
        private String[] toppings;
        
        public Pizza(String[] toppings) {
            super("Pizza", 25);
            this.toppings = toppings;
        }
        
        @Override
        protected void wash() {
            System.out.println("Washing vegetables: " + String.join(", ", toppings));
        }
        
        @Override
        protected void cook() {
            System.out.println("Rolling pizza dough");
            System.out.println("Adding sauce and toppings: " + String.join(", ", toppings));
            System.out.println("Baking pizza in oven for " + cookingTime + " minutes");
        }
        
        @Override
        protected void serve() {
            System.out.println("Cutting pizza into slices");
            super.serve();
        }
    }
    
    public static class Soup extends Food {
        private String[] ingredients;
        private String broth;
        
        public Soup(String[] ingredients, String broth) {
            super("Soup", 45);
            this.ingredients = ingredients;
            this.broth = broth;
        }
        
        @Override
        protected void wash() {
            System.out.println("Washing and chopping ingredients: " + String.join(", ", ingredients));
        }
        
        @Override
        protected void cook() {
            System.out.println("Heating " + broth + " broth");
            System.out.println("Adding ingredients: " + String.join(", ", ingredients));
            System.out.println("Simmering soup for " + cookingTime + " minutes");
        }
        
        @Override
        protected void serve() {
            System.out.println("Ladling soup into bowls");
            System.out.println("Garnishing with herbs");
        }
    }
    
    public static class Pasta extends Food {
        private String pastaType;
        private String sauce;
        
        public Pasta(String pastaType, String sauce) {
            super("Pasta", 15);
            this.pastaType = pastaType;
            this.sauce = sauce;
        }
        
        @Override
        protected void wash() {
            System.out.println("Rinsing " + pastaType + " pasta");
        }
        
        @Override
        protected void cook() {
            System.out.println("Boiling water for " + pastaType + " pasta");
            System.out.println("Cooking pasta for " + cookingTime + " minutes");
            System.out.println("Preparing " + sauce + " sauce");
            System.out.println("Mixing pasta with " + sauce + " sauce");
        }
        
        @Override
        protected void serve() {
            System.out.println("Plating pasta with sauce");
            System.out.println("Sprinkling parmesan cheese on top");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Template Method Pattern Demo ===");
        
        Food[] menu = {
            new Pizza(new String[]{"Pepperoni", "Mushrooms", "Cheese"}),
            new Soup(new String[]{"Carrots", "Celery", "Onions", "Chicken"}, "Chicken"),
            new Pasta("Spaghetti", "Marinara")
        };
        
        System.out.println("Preparing today's menu:\n");
        
        for (Food food : menu) {
            food.prepare(); // Template method call
        }
        
        System.out.println("=== Template Method Benefits ===");
        System.out.println("✓ Common algorithm structure defined in base class");
        System.out.println("✓ Subclasses implement specific steps");
        System.out.println("✓ Code reuse and consistent process flow");
        System.out.println("✓ Easy to add new food types following same pattern");
    }
}