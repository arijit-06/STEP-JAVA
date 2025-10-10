/*
LAB PROBLEM 4: Cloning an Object
Topic: Object Cloning – Shallow Copy vs Deep Copy
*/

class Address implements Cloneable {
    private String city;
    private String state;
    
    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "Address{city='" + city + "', state='" + state + "'}";
    }
    
    public void setCity(String city) { this.city = city; }
}

class Person implements Cloneable {
    private String name;
    private Address address;
    
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    
    // Shallow clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // Deep clone method
    public Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = (Address) this.address.clone();
        return cloned;
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', address=" + address + "}";
    }
    
    public Address getAddress() { return address; }
}

public class PersonCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=== Object Cloning Demo ===");
        
        Address originalAddress = new Address("New York", "NY");
        Person original = new Person("John", originalAddress);
        
        System.out.println("\n--- Original Object ---");
        System.out.println("Original: " + original);
        
        // Shallow clone
        Person shallowClone = (Person) original.clone();
        System.out.println("\n--- Shallow Clone ---");
        System.out.println("Shallow clone: " + shallowClone);
        
        // Deep clone
        Person deepClone = original.deepClone();
        System.out.println("\n--- Deep Clone ---");
        System.out.println("Deep clone: " + deepClone);
        
        // Modify address in shallow clone
        System.out.println("\n--- Modifying Shallow Clone Address ---");
        shallowClone.getAddress().setCity("Boston");
        
        System.out.println("After modifying shallow clone:");
        System.out.println("Original: " + original);
        System.out.println("Shallow clone: " + shallowClone);
        System.out.println("Deep clone: " + deepClone);
        
        System.out.println("\n--- Analysis ---");
        System.out.println("Shallow clone shares address reference with original");
        System.out.println("Deep clone has independent address object");
    }
}