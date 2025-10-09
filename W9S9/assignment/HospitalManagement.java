/*
Problem 5: Member Inner Class
Problem: "Hospital Management"
*/

class Hospital {
    private String name;
    private String location;
    
    public Hospital(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    // Member Inner Class
    public class Department {
        private String deptName;
        private String headDoctor;
        private int bedCount;
        
        public Department(String deptName, String headDoctor, int bedCount) {
            this.deptName = deptName;
            this.headDoctor = headDoctor;
            this.bedCount = bedCount;
        }
        
        // TODO: Display department info along with hospital name
        public void displayInfo() {
            System.out.println("=== Department Information ===");
            System.out.println("Hospital: " + name + " (" + location + ")"); // Accessing outer class members
            System.out.println("Department: " + deptName);
            System.out.println("Head Doctor: " + headDoctor);
            System.out.println("Bed Count: " + bedCount);
        }
        
        public void admitPatient(String patientName) {
            System.out.println("Patient " + patientName + " admitted to " + deptName + 
                             " department at " + name);
        }
        
        public String getDeptName() { return deptName; }
        public String getHeadDoctor() { return headDoctor; }
        public int getBedCount() { return bedCount; }
    }
    
    // TODO: Method to create Department object
    public Department createDepartment(String deptName, String headDoctor, int bedCount) {
        return new Department(deptName, headDoctor, bedCount);
    }
    
    public String getName() { return name; }
    public String getLocation() { return location; }
}

public class HospitalManagement {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System ===");
        
        // 1. Create Hospital with 2 Departments, display info
        Hospital hospital = new Hospital("City General Hospital", "Downtown");
        
        // Creating departments using inner class
        Hospital.Department cardiology = hospital.createDepartment("Cardiology", "Dr. Smith", 25);
        Hospital.Department neurology = hospital.createDepartment("Neurology", "Dr. Johnson", 20);
        
        System.out.println("\n--- Department 1 ---");
        cardiology.displayInfo();
        cardiology.admitPatient("John Doe");
        
        System.out.println("\n--- Department 2 ---");
        neurology.displayInfo();
        neurology.admitPatient("Jane Smith");
        
        // Alternative way to create department
        System.out.println("\n--- Alternative Department Creation ---");
        Hospital.Department emergency = hospital.new Department("Emergency", "Dr. Brown", 15);
        emergency.displayInfo();
        emergency.admitPatient("Mike Wilson");
        
        System.out.println("\n=== Hospital Summary ===");
        System.out.println("Hospital: " + hospital.getName());
        System.out.println("Location: " + hospital.getLocation());
        System.out.println("Departments:");
        System.out.println("- " + cardiology.getDeptName() + " (Head: " + cardiology.getHeadDoctor() + ")");
        System.out.println("- " + neurology.getDeptName() + " (Head: " + neurology.getHeadDoctor() + ")");
        System.out.println("- " + emergency.getDeptName() + " (Head: " + emergency.getHeadDoctor() + ")");
        
        System.out.println("\n=== Inner Class Benefits ===");
        System.out.println("- Department has direct access to Hospital's private members");
        System.out.println("- Logical grouping of related classes");
        System.out.println("- Encapsulation at class level");
    }
}