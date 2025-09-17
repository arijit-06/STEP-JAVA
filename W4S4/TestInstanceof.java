class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class TestInstanceof {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat(), new Dog(), new Animal() };
        
        int dogCount = 0;
        int catCount = 0;
        int animalCount = 0;
        
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                dogCount++;
            } else if (animal instanceof Cat) {
                catCount++;
            } else if (animal instanceof Animal) {
                animalCount++;
            }
        }
        
        System.out.println("Number of Dogs: " + dogCount);
        System.out.println("Number of Cats: " + catCount);
        System.out.println("Number of Animals (base): " + animalCount);
    }
}