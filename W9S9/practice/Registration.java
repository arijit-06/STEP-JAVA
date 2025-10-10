/*
Practice Problem 4: clone(), Shallow vs Deep Copy
Problem: "Course Registration System"
*/

class ContactInfo implements Cloneable {
    private String email;
    private String phone;
    
    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "ContactInfo{email='" + email + "', phone='" + phone + "'}";
    }
    
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}

class Student implements Cloneable {
    private String id;
    private String name;
    private ContactInfo contact;
    
    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    // Shallow clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    // Deep clone
    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) this.contact.clone();
        return cloned;
    }
    
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', contact=" + contact + "}";
    }
    
    public ContactInfo getContact() { return contact; }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("=== Course Registration System ===");
        
        ContactInfo originalContact = new ContactInfo("john@email.com", "9876543210");
        Student original = new Student("CS101", "John Doe", originalContact);
        
        System.out.println("\n--- Original Student ---");
        System.out.println("Original: " + original);
        
        // Shallow clone
        Student shallowClone = (Student) original.clone();
        System.out.println("\n--- Shallow Clone ---");
        System.out.println("Shallow clone: " + shallowClone);
        
        // Deep clone
        Student deepClone = original.deepClone();
        System.out.println("\n--- Deep Clone ---");
        System.out.println("Deep clone: " + deepClone);
        
        // Modify contact in shallow clone
        System.out.println("\n--- Modifying Shallow Clone Contact ---");
        shallowClone.getContact().setEmail("john.updated@email.com");
        shallowClone.getContact().setPhone("1234567890");
        
        System.out.println("After modifying shallow clone contact:");
        System.out.println("Original: " + original);
        System.out.println("Shallow clone: " + shallowClone);
        System.out.println("Deep clone: " + deepClone);
        
        System.out.println("\n--- Analysis ---");
        System.out.println("Shallow clone: Contact reference shared with original");
        System.out.println("Deep clone: Independent contact object created");
    }
}