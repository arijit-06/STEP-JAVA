/*
Problem 7: Anonymous Inner Class
Problem: "Notification Service"
*/

interface Notifier {
    void send(String message);
}

class Service {
    private String serviceName;
    
    public Service(String serviceName) {
        this.serviceName = serviceName;
    }
    
    public void triggerAlert() {
        // TODO: Create Notifier instance using anonymous inner class and send an alert
        Notifier emailNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("📧 EMAIL ALERT from " + serviceName + ": " + message);
                System.out.println("Sent to: admin@company.com");
            }
        };
        
        Notifier smsNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("📱 SMS ALERT from " + serviceName + ": " + message);
                System.out.println("Sent to: +1-555-0123");
            }
        };
        
        Notifier pushNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("🔔 PUSH NOTIFICATION from " + serviceName + ": " + message);
                System.out.println("Sent to: Mobile App Users");
            }
        };
        
        // Send alerts through different channels
        String alertMessage = "System maintenance scheduled at 2 AM";
        
        emailNotifier.send(alertMessage);
        smsNotifier.send(alertMessage);
        pushNotifier.send(alertMessage);
    }
    
    public void processOrder(String orderId) {
        System.out.println("\n=== Processing Order: " + orderId + " ===");
        
        // Anonymous inner class for order confirmation
        Notifier orderNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("📦 ORDER UPDATE: " + message);
                System.out.println("Order ID: " + orderId);
                System.out.println("Service: " + serviceName);
            }
        };
        
        orderNotifier.send("Order confirmed and being processed");
        orderNotifier.send("Order shipped successfully");
    }
    
    public void monitorSystem() {
        System.out.println("\n=== System Monitoring ===");
        
        // Multiple anonymous classes for different monitoring alerts
        Notifier[] monitors = {
            new Notifier() {
                @Override
                public void send(String message) {
                    System.out.println("🖥️ CPU MONITOR: " + message);
                }
            },
            new Notifier() {
                @Override
                public void send(String message) {
                    System.out.println("💾 MEMORY MONITOR: " + message);
                }
            },
            new Notifier() {
                @Override
                public void send(String message) {
                    System.out.println("🌐 NETWORK MONITOR: " + message);
                }
            }
        };
        
        String[] alerts = {
            "CPU usage at 85%",
            "Memory usage at 90%",
            "Network latency increased"
        };
        
        for (int i = 0; i < monitors.length; i++) {
            monitors[i].send(alerts[i]);
        }
    }
}

public class NotificationService {
    public static void main(String[] args) {
        System.out.println("=== Notification Service Demo ===");
        
        Service service = new Service("E-Commerce Platform");
        
        System.out.println("\n--- System Alert Notifications ---");
        service.triggerAlert();
        
        System.out.println("\n--- Order Processing Notifications ---");
        service.processOrder("ORD-12345");
        
        System.out.println("\n--- System Monitoring Notifications ---");
        service.monitorSystem();
        
        // Additional anonymous inner class example
        System.out.println("\n--- Custom Notification Channel ---");
        Notifier customNotifier = new Notifier() {
            @Override
            public void send(String message) {
                System.out.println("🔊 CUSTOM ALERT: " + message.toUpperCase());
                System.out.println("Priority: HIGH");
                System.out.println("Timestamp: " + System.currentTimeMillis());
            }
        };
        
        customNotifier.send("Critical system error detected");
        
        System.out.println("\n=== Anonymous Inner Class Benefits ===");
        System.out.println("- Quick implementation of interfaces");
        System.out.println("- Access to outer class members");
        System.out.println("- No need for separate class files");
        System.out.println("- Perfect for event handling and callbacks");
    }
}