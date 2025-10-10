/*
Practice Problem 5: Member Inner Class
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
        private int bedCount;
        
        public Department(String deptName, int bedCount) {
            this.deptName = deptName;
            this.bedCount = bedCount;
        }
        
        public void displayInfo() {
            System.out.println("=== Department Information ===");
            System.out.println("Hospital: " + name + " (" + location + ")");
            System.out.println("Department: " + deptName);
            System.out.println("Bed Count: " + bedCount);
            System.out.println("Full Address: " + deptName + " Dept, " + name + ", " + location);
        }
        
        public void updateBedCount(int newCount) {
            this.bedCount = newCount;
            System.out.println("Updated bed count for " + deptName + ": " + bedCount);
        }
    }
    
    public Department createDepartment(String deptName, int bedCount) {
        return new Department(deptName, bedCount);
    }
    
    public void displayHospitalInfo() {
        System.out.println("Hospital: " + name + ", Location: " + location);
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        System.out.println("=== Hospital Management System ===");
        
        Hospital hospital = new Hospital("City General Hospital", "Downtown");
        
        System.out.println("\n--- Hospital Information ---");
        hospital.displayHospitalInfo();
        
        // Create departments using inner class
        Hospital.Department cardiology = hospital.new Department("Cardiology", 50);
        Hospital.Department neurology = hospital.createDepartment("Neurology", 30);
        
        System.out.println("\n--- Department 1 ---");
        cardiology.displayInfo();
        
        System.out.println("\n--- Department 2 ---");
        neurology.displayInfo();
        
        System.out.println("\n--- Updating Department ---");
        cardiology.updateBedCount(60);
        cardiology.displayInfo();
        
        System.out.println("\n--- Creating Another Hospital ---");
        Hospital hospital2 = new Hospital("Metro Medical Center", "Uptown");
        Hospital.Department emergency = hospital2.new Department("Emergency", 25);
        emergency.displayInfo();
    }
}