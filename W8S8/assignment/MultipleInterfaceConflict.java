/*
Topic 6: Multiple Interfaces with Same Method Name
Problem Statement:
Create two interfaces Printer and Scanner, each having a method connect().
Create a class AllInOneMachine that implements both interfaces and provides its own
implementation for connect().
Demonstrate how a single class can resolve method name conflicts and handle multiple
interfaces.
Hints:
● Use interface Printer and interface Scanner.
● Both will have a method void connect().
● In AllInOneMachine, implement both connect() methods (since they have same
signature, one method will serve both).
● Create objects and test with references:
○ Printer p = new AllInOneMachine();
○ Scanner s = new AllInOneMachine();
*/

interface Printer {
    void connect();
    
    default void printDocument(String document) {
        System.out.println("📄 Printing document: " + document);
    }
    
    default void printerStatus() {
        System.out.println("Printer is ready for printing");
    }
    
    static void printerMaintenanceTips() {
        System.out.println("Printer Maintenance Tips:");
        System.out.println("- Replace ink cartridges when low");
        System.out.println("- Clean print heads regularly");
        System.out.println("- Use quality paper for best results");
        System.out.println("- Keep printer in dust-free environment");
    }
}

interface Scanner {
    void connect();
    
    default void scanDocument(String documentName) {
        System.out.println("📷 Scanning document: " + documentName);
    }
    
    default void scannerStatus() {
        System.out.println("Scanner is ready for scanning");
    }
    
    static void scannerMaintenanceTips() {
        System.out.println("Scanner Maintenance Tips:");
        System.out.println("- Clean scanner glass regularly");
        System.out.println("- Calibrate scanner for color accuracy");
        System.out.println("- Handle documents carefully to avoid jams");
        System.out.println("- Update scanner drivers periodically");
    }
}

class AllInOneMachine implements Printer, Scanner {
    private String brand;
    private String model;
    private boolean isPrinterConnected;
    private boolean isScannerConnected;
    private boolean isPowerOn;
    private String connectionType;
    private String ipAddress;
    
    public AllInOneMachine(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isPrinterConnected = false;
        this.isScannerConnected = false;
        this.isPowerOn = false;
        this.connectionType = "USB";
        this.ipAddress = "192.168.1.100";
    }
    
    public AllInOneMachine(String brand, String model, String connectionType, String ipAddress) {
        this.brand = brand;
        this.model = model;
        this.isPrinterConnected = false;
        this.isScannerConnected = false;
        this.isPowerOn = false;
        this.connectionType = connectionType;
        this.ipAddress = ipAddress;
    }
    
    @Override
    public void connect() {
        System.out.println("\n🔌 Connecting " + brand + " " + model + " All-in-One Machine...");
        
        if (!isPowerOn) {
            System.out.println("⚡ Powering on the device...");
            isPowerOn = true;
        }
        
        System.out.println("Connection Type: " + connectionType);
        if (connectionType.equals("WiFi") || connectionType.equals("Ethernet")) {
            System.out.println("IP Address: " + ipAddress);
        }
        
        System.out.println("🖨️ Establishing printer connection...");
        isPrinterConnected = true;
        System.out.println("✅ Printer connected successfully");
        
        System.out.println("📷 Establishing scanner connection...");
        isScannerConnected = true;
        System.out.println("✅ Scanner connected successfully");
        
        System.out.println("🎉 All-in-One machine fully connected and ready!");
        System.out.println("Available functions: Print, Scan, Copy, Fax");
    }
    
    public void disconnect() {
        System.out.println("\n🔌 Disconnecting " + brand + " " + model + "...");
        
        if (isPrinterConnected) {
            System.out.println("🖨️ Disconnecting printer...");
            isPrinterConnected = false;
        }
        
        if (isScannerConnected) {
            System.out.println("📷 Disconnecting scanner...");
            isScannerConnected = false;
        }
        
        System.out.println("✅ All-in-One machine disconnected");
    }
    
    @Override
    public void printDocument(String document) {
        if (!isPrinterConnected) {
            System.out.println("❌ Cannot print - printer not connected");
            return;
        }
        
        System.out.println("\n🖨️ " + brand + " " + model + " - Printing Mode");
        System.out.println("Document: " + document);
        System.out.println("Preparing print job...");
        System.out.println("Feeding paper...");
        System.out.println("Applying ink to paper...");
        System.out.println("✅ Document '" + document + "' printed successfully!");
    }
    
    @Override
    public void scanDocument(String documentName) {
        if (!isScannerConnected) {
            System.out.println("❌ Cannot scan - scanner not connected");
            return;
        }
        
        System.out.println("\n📷 " + brand + " " + model + " - Scanning Mode");
        System.out.println("Document: " + documentName);
        System.out.println("Positioning document on scanner bed...");
        System.out.println("Calibrating scanner light...");
        System.out.println("Scanning in progress...");
        System.out.println("Processing scanned image...");
        System.out.println("✅ Document '" + documentName + "' scanned successfully!");
        System.out.println("Saved as: " + documentName + "_scanned.pdf");
    }
    
    @Override
    public void printerStatus() {
        System.out.println("\n🖨️ Printer Status:");
        System.out.println("Connection: " + (isPrinterConnected ? "Connected" : "Disconnected"));
        System.out.println("Ink Levels: Cyan 85%, Magenta 92%, Yellow 78%, Black 88%");
        System.out.println("Paper Tray: 250 sheets loaded");
        System.out.println("Status: " + (isPrinterConnected ? "Ready to print" : "Offline"));
    }
    
    @Override
    public void scannerStatus() {
        System.out.println("\n📷 Scanner Status:");
        System.out.println("Connection: " + (isScannerConnected ? "Connected" : "Disconnected"));
        System.out.println("Resolution: 1200 DPI");
        System.out.println("Scanner Bed: Clean and ready");
        System.out.println("Status: " + (isScannerConnected ? "Ready to scan" : "Offline"));
    }
    
    public void displayDeviceInfo() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        ALL-IN-ONE MACHINE INFO");
        System.out.println("=".repeat(50));
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Power Status: " + (isPowerOn ? "ON" : "OFF"));
        System.out.println("Connection Type: " + connectionType);
        if (!connectionType.equals("USB")) {
            System.out.println("IP Address: " + ipAddress);
        }
        System.out.println("Printer Connected: " + (isPrinterConnected ? "Yes" : "No"));
        System.out.println("Scanner Connected: " + (isScannerConnected ? "Yes" : "No"));
        System.out.println("=".repeat(50));
    }
    
    public void copyDocument(String documentName, int copies) {
        if (!isPrinterConnected || !isScannerConnected) {
            System.out.println("❌ Cannot copy - both printer and scanner must be connected");
            return;
        }
        
        System.out.println("\n📋 " + brand + " " + model + " - Copy Mode");
        System.out.println("Document: " + documentName);
        System.out.println("Copies requested: " + copies);
        
        for (int i = 1; i <= copies; i++) {
            System.out.println("Scanning original document...");
            System.out.println("Printing copy " + i + " of " + copies + "...");
        }
        
        System.out.println("✅ " + copies + " copies of '" + documentName + "' completed!");
    }
    
    public void faxDocument(String documentName, String faxNumber) {
        if (!isPrinterConnected || !isScannerConnected) {
            System.out.println("❌ Cannot fax - device not fully connected");
            return;
        }
        
        System.out.println("\n📠 " + brand + " " + model + " - Fax Mode");
        System.out.println("Document: " + documentName);
        System.out.println("Fax Number: " + faxNumber);
        System.out.println("Scanning document for transmission...");
        System.out.println("Dialing fax number...");
        System.out.println("Transmitting document...");
        System.out.println("✅ Fax sent successfully to " + faxNumber);
    }
    
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public boolean isPrinterConnected() { return isPrinterConnected; }
    public boolean isScannerConnected() { return isScannerConnected; }
    public boolean isPowerOn() { return isPowerOn; }
}

class SimplePrinter implements Printer {
    private String model;
    private boolean isConnected;
    
    public SimplePrinter(String model) {
        this.model = model;
        this.isConnected = false;
    }
    
    @Override
    public void connect() {
        System.out.println("\n🖨️ Connecting " + model + " printer...");
        isConnected = true;
        System.out.println("✅ Printer connected via USB");
    }
    
    @Override
    public void printDocument(String document) {
        if (!isConnected) {
            System.out.println("❌ Printer not connected");
            return;
        }
        System.out.println("🖨️ Printing: " + document);
    }
}

class SimpleScanner implements Scanner {
    private String model;
    private boolean isConnected;
    
    public SimpleScanner(String model) {
        this.model = model;
        this.isConnected = false;
    }
    
    @Override
    public void connect() {
        System.out.println("\n📷 Connecting " + model + " scanner...");
        isConnected = true;
        System.out.println("✅ Scanner connected via USB");
    }
    
    @Override
    public void scanDocument(String documentName) {
        if (!isConnected) {
            System.out.println("❌ Scanner not connected");
            return;
        }
        System.out.println("📷 Scanning: " + documentName);
    }
}

public class MultipleInterfaceConflict {
    public static void main(String[] args) {
        System.out.println("=== Multiple Interfaces with Same Method Name Demo ===");
        
        Printer.printerMaintenanceTips();
        System.out.println();
        Scanner.scannerMaintenanceTips();
        
        AllInOneMachine allInOne1 = new AllInOneMachine("HP", "OfficeJet Pro 9015", "WiFi", "192.168.1.105");
        AllInOneMachine allInOne2 = new AllInOneMachine("Canon", "PIXMA TR8620");
        SimplePrinter printer = new SimplePrinter("Epson EcoTank L3150");
        SimpleScanner scanner = new SimpleScanner("Canon LiDE 400");
        
        System.out.println("\n=== All-in-One Machine 1 Demo ===");
        allInOne1.displayDeviceInfo();
        allInOne1.connect(); // Single method serves both Printer and Scanner interfaces
        allInOne1.printerStatus();
        allInOne1.scannerStatus();
        
        allInOne1.printDocument("Monthly Report.docx");
        allInOne1.scanDocument("Contract.pdf");
        allInOne1.copyDocument("Invoice.pdf", 3);
        allInOne1.faxDocument("Purchase Order.pdf", "+1-555-0123");
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n=== All-in-One Machine 2 Demo ===");
        allInOne2.displayDeviceInfo();
        allInOne2.connect();
        allInOne2.printDocument("Presentation.pptx");
        allInOne2.scanDocument("Receipt.jpg");
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n=== Method Name Conflict Resolution Demo ===");
        
        // Using Printer interface reference
        System.out.println("\n--- Using Printer Interface Reference ---");
        Printer p = new AllInOneMachine("Brother", "MFC-L3770CDW", "Ethernet", "192.168.1.110");
        p.connect(); // Calls the same connect() method
        p.printerStatus();
        p.printDocument("Test Page.txt");
        
        // Using Scanner interface reference
        System.out.println("\n--- Using Scanner Interface Reference ---");
        Scanner s = new AllInOneMachine("Xerox", "WorkCentre 6515", "WiFi", "192.168.1.115");
        s.connect(); // Calls the same connect() method
        s.scannerStatus();
        s.scanDocument("Photo.jpg");
        
        System.out.println("\n=== Polymorphic Interface Array Demo ===");
        
        // Array of Printer references
        Printer[] printers = {allInOne1, allInOne2, p, printer};
        System.out.println("\nConnecting all printers:");
        for (Printer printerDevice : printers) {
            printerDevice.connect();
        }
        
        System.out.println("\nPrinting test documents:");
        String[] documents = {"Document1.pdf", "Document2.docx", "Document3.txt", "Document4.xlsx"};
        for (int i = 0; i < printers.length; i++) {
            printers[i].printDocument(documents[i]);
        }
        
        // Array of Scanner references
        Scanner[] scanners = {allInOne1, allInOne2, s, scanner};
        System.out.println("\nConnecting all scanners:");
        for (Scanner scannerDevice : scanners) {
            scannerDevice.connect();
        }
        
        System.out.println("\nScanning test documents:");
        String[] scanDocs = {"Photo1.jpg", "Photo2.png", "Document1.pdf", "Receipt.jpg"};
        for (int i = 0; i < scanners.length; i++) {
            scanners[i].scanDocument(scanDocs[i]);
        }
        
        System.out.println("\n=== Interface Method Conflict Analysis ===");
        System.out.println("Demonstrating that one connect() method serves both interfaces:");
        
        AllInOneMachine testMachine = new AllInOneMachine("Samsung", "Xpress M2885FW");
        
        System.out.println("\n1. Direct object method call:");
        testMachine.connect();
        
        System.out.println("\n2. Through Printer interface:");
        Printer printerRef = testMachine;
        printerRef.connect();
        
        System.out.println("\n3. Through Scanner interface:");
        Scanner scannerRef = testMachine;
        scannerRef.connect();
        
        System.out.println("\n=== Office Workflow Simulation ===");
        AllInOneMachine officeDevice = new AllInOneMachine("Ricoh", "MP C3004", "Ethernet", "192.168.1.120");
        
        System.out.println("Daily office tasks:");
        officeDevice.connect();
        
        System.out.println("\nMorning tasks:");
        officeDevice.scanDocument("Incoming Mail.pdf");
        officeDevice.printDocument("Daily Schedule.docx");
        
        System.out.println("\nAfternoon tasks:");
        officeDevice.copyDocument("Client Proposal.pdf", 5);
        officeDevice.faxDocument("Signed Contract.pdf", "+1-555-0199");
        
        System.out.println("\nEnd of day:");
        officeDevice.disconnect();
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Both Printer and Scanner interfaces have connect() method with same signature");
        System.out.println("2. AllInOneMachine implements both interfaces with single connect() method");
        System.out.println("3. One method implementation satisfies both interface contracts");
        System.out.println("4. No method name conflict occurs - Java resolves automatically");
        System.out.println("5. Same object can be referenced through different interface types");
        System.out.println("6. Polymorphism works seamlessly with multiple interface implementation");
        System.out.println("7. Default methods from both interfaces are available to implementing class");
        System.out.println("8. Static methods provide utility functions for each interface");
    }
}