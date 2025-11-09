class Admin {
    private String name;
    
    public Admin(String name) {
        this.name = name;
    }
    
    public void manageAppointments() {
        System.out.println("Admin " + name + " manages appointments");
    }
    
    public void generateBills() {
        System.out.println("Admin " + name + " generates bills");
    }
    
    public void manageRecords() {
        System.out.println("Admin " + name + " manages patient records");
    }
}

class Doctor {
    private String name;
    private String specialization;
    
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    
    public void updateRecords(String patientName) {
        System.out.println("Dr. " + name + " updates records for " + patientName);
    }
    
    public void consultPatient(String patientName) {
        System.out.println("Dr. " + name + " consults " + patientName);
    }
}

class Patient {
    private String name;
    private int age;
    
    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void bookAppointment(Doctor doctor) {
        System.out.println("Patient " + name + " books appointment with Dr. " + doctor.name);
    }
    
    public void viewRecords() {
        System.out.println("Patient " + name + " views medical records");
    }
}

public class HospitalManagement {
    public static void main(String[] args) {
        System.out.println("Use Case Diagram - Hospital Management System:");
        
        Admin admin = new Admin("Alice");
        Doctor doctor = new Doctor("Smith", "Cardiology");
        Patient patient = new Patient("John", 35);
        
        admin.manageAppointments();
        patient.bookAppointment(doctor);
        doctor.consultPatient("John");
        doctor.updateRecords("John");
        admin.generateBills();
        patient.viewRecords();
    }
}