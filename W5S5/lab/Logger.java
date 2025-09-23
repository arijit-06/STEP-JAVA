// File: Logger.java
// LAB 5: Singleton Design Pattern

public class Logger {
    
    private static Logger instance;
    private static final Object lock = new Object();
    private boolean enabled;
    private String logLevel;
    
    private Logger() {
        this.enabled = true;
        this.logLevel = "INFO";
        System.out.println("Logger instance created");
    }
    
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    public void log(String message) {
        if (enabled) {
            System.out.println("[" + logLevel + "] " + getCurrentTime() + " - " + message);
        }
    }
    
    public void info(String message) {
        if (enabled) {
            System.out.println("[INFO] " + getCurrentTime() + " - " + message);
        }
    }
    
    public void error(String message) {
        if (enabled) {
            System.out.println("[ERROR] " + getCurrentTime() + " - " + message);
        }
    }
    
    public void debug(String message) {
        if (enabled && logLevel.equals("DEBUG")) {
            System.out.println("[DEBUG] " + getCurrentTime() + " - " + message);
        }
    }
    
    public void setLogLevel(String level) {
        this.logLevel = level;
    }
    
    public void enable() { this.enabled = true; }
    public void disable() { this.enabled = false; }
    
    private String getCurrentTime() {
        return java.time.LocalTime.now().toString().substring(0, 8);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Singleton Logger Demo ===");
        
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        System.out.println("Same instance: " + (logger1 == logger2));
        
        logger1.info("Application started");
        logger1.error("Sample error message");
        
        logger1.setLogLevel("DEBUG");
        logger1.debug("Debug information");
        
        logger2.log("Message from logger2");
        
        logger1.disable();
        logger1.info("This won't be displayed");
        
        logger1.enable();
        logger1.info("Logging re-enabled");
    }
}