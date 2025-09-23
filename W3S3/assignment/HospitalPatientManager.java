class Patient {
    private String patientId;
    private String patientName;
    private int age;
    private String gender;
    private String contactInfo;
    private String[] medicalHistory;
    private String[] currentTreatments;
    private int historyCount;
    private int treatmentCount;
    
    private static int totalPatients = 0;
    
    public Patient(String patientName, int age, String gender, String contactInfo) {
        this.patientId = generatePatientId();
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.medicalHistory = new String[10];
        this.currentTreatments = new String[5];
        this.historyCount = 0;
        this.treatmentCount = 0;
        totalPatients++;
    }
    
    private static String generatePatientId() {
        return "P" + String.format("%04d", totalPatients + 1);
    }
    
    public void addMedicalHistory(String condition) {
        if (historyCount < medicalHistory.length) {
            medicalHistory[historyCount] = condition;
            historyCount++;
            System.out.println("Added medical history for " + patientName + ": " + condition);
        }
    }
    
    public void addTreatment(String treatment) {
        if (treatmentCount < currentTreatments.length) {
            currentTreatments[treatmentCount] = treatment;
            treatmentCount++;
            System.out.println("Added treatment for " + patientName + ": " + treatment);
        }
    }
    
    public void updateTreatment(String oldTreatment, String newTreatment) {
        for (int i = 0; i < treatmentCount; i++) {
            if (currentTreatments[i].equals(oldTreatment)) {
                currentTreatments[i] = newTreatment;
                System.out.println("Updated treatment for " + patientName + ": " + oldTreatment + " -> " + newTreatment);
                return;
            }
        }
        System.out.println("Treatment not found for update");
    }
    
    public void displayPatientInfo() {
        System.out.println("=== Patient Information ===");
        System.out.println("ID: " + patientId);
        System.out.println("Name: " + patientName);
        System.out.println("Age: " + age + ", Gender: " + gender);
        System.out.println("Contact: " + contactInfo);
        
        System.out.println("Medical History:");
        for (int i = 0; i < historyCount; i++) {
            System.out.println("  - " + medicalHistory[i]);
        }
        
        System.out.println("Current Treatments:");
        for (int i = 0; i < treatmentCount; i++) {
            System.out.println("  - " + currentTreatments[i]);
        }
        System.out.println("===========================");
    }
    
    public String getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public static int getTotalPatients() { return totalPatients; }
}

class Doctor {
    private String doctorId;
    private String doctorName;
    private String specialization;
    private String[] availableSlots;
    private int patientsHandled;
    private double consultationFee;
    private boolean[] slotBooked; // Track booked slots
    
    private static int totalDoctors = 0;
    
    public Doctor(String doctorName, String specialization, double consultationFee) {
        this.doctorId = generateDoctorId();
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.patientsHandled = 0;
        
        // Initialize available slots (simplified)
        this.availableSlots = new String[]{"09:00", "10:00", "11:00", "14:00", "15:00", "16:00"};
        this.slotBooked = new boolean[availableSlots.length];
        totalDoctors++;
    }
    
    private static String generateDoctorId() {
        return "DR" + String.format("%03d", totalDoctors + 1);
    }
    
    public boolean isSlotAvailable(String time) {
        for (int i = 0; i < availableSlots.length; i++) {
            if (availableSlots[i].equals(time) && !slotBooked[i]) {
                return true;
            }
        }
        return false;
    }
    
    public void bookSlot(String time) {
        for (int i = 0; i < availableSlots.length; i++) {
            if (availableSlots[i].equals(time) && !slotBooked[i]) {
                slotBooked[i] = true;
                patientsHandled++;
                System.out.println("Slot " + time + " booked for Dr. " + doctorName);
                return;
            }
        }
        System.out.println("Slot not available");
    }
    
    public void displayDoctorInfo() {
        System.out.println("=== Doctor Information ===");
        System.out.println("ID: " + doctorId);
        System.out.println("Name: Dr. " + doctorName);
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: $" + consultationFee);
        System.out.println("Patients Handled: " + patientsHandled);
        
        System.out.println("Available Slots:");
        for (int i = 0; i < availableSlots.length; i++) {
            System.out.println("  " + availableSlots[i] + " - " + (slotBooked[i] ? "Booked" : "Available"));
        }
        System.out.println("==========================");
    }
    
    public String getDoctorId() { return doctorId; }
    public String getDoctorName() { return doctorName; }
    public String getSpecialization() { return specialization; }
    public double getConsultationFee() { return consultationFee; }
    public int getPatientsHandled() { return patientsHandled; }
    public static int getTotalDoctors() { return totalDoctors; }
}

class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String appointmentType;
    private double billAmount;
    
    private static int totalAppointments = 0;
    private static String hospitalName = "City General Hospital";
    private static double totalRevenue = 0;
    
    public Appointment(Patient patient, Doctor doctor, String appointmentDate, String appointmentTime, String appointmentType) {
        this.appointmentId = generateAppointmentId();
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.appointmentType = appointmentType;
        this.status = "Scheduled";
        
        // Calculate bill based on appointment type
        this.billAmount = calculateBill();
        
        totalAppointments++;
        totalRevenue += billAmount;
        
        // Book the doctor's slot
        doctor.bookSlot(appointmentTime);
    }
    
    private static String generateAppointmentId() {
        return "APT" + String.format("%04d", totalAppointments + 1);
    }
    
    private double calculateBill() {
        double baseFee = doctor.getConsultationFee();
        switch (appointmentType) {
            case "Consultation": return baseFee;
            case "Follow-up": return baseFee * 0.7; // 30% discount
            case "Emergency": return baseFee * 1.5; // 50% surcharge
            default: return baseFee;
        }
    }
    
    public void cancelAppointment() {
        if (status.equals("Scheduled")) {
            status = "Cancelled";
            totalRevenue -= billAmount;
            System.out.println("Appointment " + appointmentId + " cancelled");
        } else {
            System.out.println("Cannot cancel appointment - Status: " + status);
        }
    }
    
    public void completeAppointment() {
        if (status.equals("Scheduled")) {
            status = "Completed";
            System.out.println("Appointment " + appointmentId + " completed");
        }
    }
    
    public void generateBill() {
        System.out.println("=== MEDICAL BILL ===");
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient: " + patient.getPatientName());
        System.out.println("Doctor: Dr. " + doctor.getDoctorName());
        System.out.println("Specialization: " + doctor.getSpecialization());
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
        System.out.println("Type: " + appointmentType);
        System.out.println("Status: " + status);
        System.out.println("Amount: $" + billAmount);
        System.out.println("====================");
    }
    
    public void displayAppointment() {
        System.out.println("Appointment " + appointmentId + ": " + patient.getPatientName() + 
                          " with Dr. " + doctor.getDoctorName() + " on " + appointmentDate + 
                          " at " + appointmentTime + " (" + status + ")");
    }
    
    public static void generateHospitalReport() {
        System.out.println("=== HOSPITAL REPORT ===");
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Total Patients: " + Patient.getTotalPatients());
        System.out.println("Total Doctors: " + Doctor.getTotalDoctors());
        System.out.println("Total Appointments: " + totalAppointments);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Average Revenue per Appointment: $" + (totalAppointments > 0 ? totalRevenue / totalAppointments : 0));
        System.out.println("=======================");
    }
    
    public static double getDoctorUtilization(Doctor[] doctors) {
        int totalSlots = 0;
        int bookedSlots = 0;
        
        for (Doctor doctor : doctors) {
            if (doctor != null) {
                totalSlots += 6; // 6 slots per doctor
                bookedSlots += doctor.getPatientsHandled();
            }
        }
        
        return totalSlots > 0 ? (double) bookedSlots / totalSlots * 100 : 0;
    }
    
    public static void getPatientStatistics(Patient[] patients) {
        System.out.println("=== PATIENT STATISTICS ===");
        
        int[] ageGroups = new int[4]; // 0-18, 19-35, 36-60, 60+
        int male = 0, female = 0;
        
        for (Patient patient : patients) {
            if (patient != null) {
                int age = patient.getAge();
                if (age <= 18) ageGroups[0]++;
                else if (age <= 35) ageGroups[1]++;
                else if (age <= 60) ageGroups[2]++;
                else ageGroups[3]++;
                
                if (patient.getGender().equalsIgnoreCase("Male")) male++;
                else female++;
            }
        }
        
        System.out.println("Age Distribution:");
        System.out.println("  0-18 years: " + ageGroups[0]);
        System.out.println("  19-35 years: " + ageGroups[1]);
        System.out.println("  36-60 years: " + ageGroups[2]);
        System.out.println("  60+ years: " + ageGroups[3]);
        
        System.out.println("Gender Distribution:");
        System.out.println("  Male: " + male);
        System.out.println("  Female: " + female);
        System.out.println("===========================");
    }
    
    public String getAppointmentId() { return appointmentId; }
    public String getStatus() { return status; }
    public String getAppointmentType() { return appointmentType; }
    public double getBillAmount() { return billAmount; }
    public static int getTotalAppointments() { return totalAppointments; }
    public static double getTotalRevenue() { return totalRevenue; }
}

public class HospitalPatientManager {
    public static void main(String[] args) {
        // Create patients
        Patient[] patients = {
            new Patient("John Smith", 45, "Male", "555-0101"),
            new Patient("Jane Doe", 32, "Female", "555-0102"),
            new Patient("Bob Johnson", 67, "Male", "555-0103"),
            new Patient("Alice Brown", 28, "Female", "555-0104"),
            new Patient("Charlie Wilson", 15, "Male", "555-0105"),
            new Patient("Diana Davis", 52, "Female", "555-0106")
        };
        
        // Add medical history
        patients[0].addMedicalHistory("Hypertension");
        patients[0].addMedicalHistory("Diabetes Type 2");
        patients[1].addMedicalHistory("Asthma");
        patients[2].addMedicalHistory("Heart Disease");
        patients[2].addMedicalHistory("Arthritis");
        
        // Add current treatments
        patients[0].addTreatment("Blood pressure medication");
        patients[0].addTreatment("Insulin therapy");
        patients[1].addTreatment("Inhaler");
        patients[2].addTreatment("Heart medication");
        
        // Create doctors
        Doctor[] doctors = {
            new Doctor("Sarah Johnson", "Cardiology", 200.0),
            new Doctor("Michael Brown", "General Medicine", 150.0),
            new Doctor("Emily Davis", "Pediatrics", 120.0),
            new Doctor("Robert Wilson", "Orthopedics", 180.0),
            new Doctor("Lisa Garcia", "Dermatology", 160.0)
        };
        
        System.out.println("=== Hospital Patient Management System ===");
        Appointment.generateHospitalReport();
        
        System.out.println("\n=== Patient Information ===");
        for (Patient patient : patients) {
            patient.displayPatientInfo();
            System.out.println();
        }
        
        System.out.println("=== Doctor Information ===");
        for (Doctor doctor : doctors) {
            doctor.displayDoctorInfo();
            System.out.println();
        }
        
        System.out.println("=== Scheduling Appointments ===");
        Appointment[] appointments = {
            new Appointment(patients[0], doctors[0], "2024-01-15", "09:00", "Consultation"),
            new Appointment(patients[1], doctors[1], "2024-01-15", "10:00", "Consultation"),
            new Appointment(patients[2], doctors[0], "2024-01-15", "11:00", "Follow-up"),
            new Appointment(patients[3], doctors[2], "2024-01-16", "09:00", "Consultation"),
            new Appointment(patients[4], doctors[2], "2024-01-16", "10:00", "Consultation"),
            new Appointment(patients[5], doctors[4], "2024-01-16", "14:00", "Consultation"),
            new Appointment(patients[0], doctors[1], "2024-01-17", "15:00", "Emergency")
        };
        
        System.out.println("\n=== Scheduled Appointments ===");
        for (Appointment appointment : appointments) {
            appointment.displayAppointment();
        }
        
        System.out.println("\n=== Generating Bills ===");
        for (int i = 0; i < 3; i++) { // Generate bills for first 3 appointments
            appointments[i].generateBill();
            System.out.println();
        }
        
        System.out.println("=== Appointment Management ===");
        appointments[1].completeAppointment();
        appointments[2].cancelAppointment();
        
        System.out.println("\n=== Updated Doctor Schedules ===");
        for (Doctor doctor : doctors) {
            doctor.displayDoctorInfo();
            System.out.println();
        }
        
        System.out.println("=== Hospital Statistics ===");
        Appointment.generateHospitalReport();
        
        System.out.println("\n=== Doctor Utilization ===");
        System.out.println("Overall Doctor Utilization: " + Appointment.getDoctorUtilization(doctors) + "%");
        
        System.out.println("\n=== Patient Demographics ===");
        Appointment.getPatientStatistics(patients);
        
        System.out.println("=== Specialization Analysis ===");
        String[] specializations = {"Cardiology", "General Medicine", "Pediatrics", "Orthopedics", "Dermatology"};
        for (String spec : specializations) {
            int appointmentCount = 0;
            double revenue = 0;
            
            for (Appointment apt : appointments) {
                if (apt != null && apt.getStatus().equals("Scheduled") && 
                    doctors[0].getSpecialization().equals(spec)) { // Simplified check
                    appointmentCount++;
                    revenue += apt.getBillAmount();
                }
            }
            
            // Count actual appointments by specialization
            appointmentCount = 0;
            revenue = 0;
            for (Doctor doctor : doctors) {
                if (doctor.getSpecialization().equals(spec)) {
                    appointmentCount += doctor.getPatientsHandled();
                    revenue += doctor.getPatientsHandled() * doctor.getConsultationFee();
                }
            }
            
            if (appointmentCount > 0) {
                System.out.println(spec + ": " + appointmentCount + " appointments, $" + revenue + " revenue");
            }
        }
        
        System.out.println("\n=== Treatment Updates ===");
        patients[0].updateTreatment("Insulin therapy", "Advanced insulin pump");
        patients[1].addTreatment("Allergy medication");
        
        System.out.println("\n=== Appointment Type Analysis ===");
        int consultation = 0, followUp = 0, emergency = 0;
        double consultationRevenue = 0, followUpRevenue = 0, emergencyRevenue = 0;
        
        for (Appointment apt : appointments) {
            if (apt != null) {
                switch (apt.getAppointmentType()) {
                    case "Consultation":
                        consultation++;
                        consultationRevenue += apt.getBillAmount();
                        break;
                    case "Follow-up":
                        followUp++;
                        followUpRevenue += apt.getBillAmount();
                        break;
                    case "Emergency":
                        emergency++;
                        emergencyRevenue += apt.getBillAmount();
                        break;
                }
            }
        }
        
        System.out.println("Consultation: " + consultation + " appointments ($" + consultationRevenue + ")");
        System.out.println("Follow-up: " + followUp + " appointments ($" + followUpRevenue + ")");
        System.out.println("Emergency: " + emergency + " appointments ($" + emergencyRevenue + ")");
        
        System.out.println("\n=== Hospital Management Features Demonstrated ===");
        System.out.println("✓ Patient record management with medical history");
        System.out.println("✓ Doctor scheduling and slot management");
        System.out.println("✓ Multiple appointment types with different billing");
        System.out.println("✓ Comprehensive billing and revenue tracking");
        System.out.println("✓ Hospital-wide statistics and reporting");
        System.out.println("✓ Patient demographics and treatment tracking");
    }
}