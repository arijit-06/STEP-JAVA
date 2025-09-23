// File: ConfigLoader.java
// LAB 6: Static Initialization Blocks

public class ConfigLoader {
    
    public static class SystemConfig {
        private static final String CONFIG_FILE = "system.properties";
        private static String serverHost;
        private static int serverPort;
        private static String databaseUrl;
        private static boolean initialized = false;
        
        static {
            System.out.println("Loading system configuration...");
            try {
                loadConfiguration();
                initialized = true;
                System.out.println("Configuration loaded successfully");
            } catch (Exception e) {
                System.err.println("Failed to load configuration: " + e.getMessage());
                setDefaultConfiguration();
            }
        }
        
        private static void loadConfiguration() {
            // Simulate loading from properties file
            serverHost = "localhost";
            serverPort = 8080;
            databaseUrl = "jdbc:mysql://localhost:3306/myapp";
            System.out.println("Configuration loaded from " + CONFIG_FILE);
        }
        
        private static void setDefaultConfiguration() {
            serverHost = "127.0.0.1";
            serverPort = 3000;
            databaseUrl = "jdbc:h2:mem:testdb";
            System.out.println("Using default configuration");
        }
        
        public static String getServerHost() { return serverHost; }
        public static int getServerPort() { return serverPort; }
        public static String getDatabaseUrl() { return databaseUrl; }
        public static boolean isInitialized() { return initialized; }
        
        public static void displayConfiguration() {
            System.out.println("=== System Configuration ===");
            System.out.println("Server Host: " + serverHost);
            System.out.println("Server Port: " + serverPort);
            System.out.println("Database URL: " + databaseUrl);
            System.out.println("Initialized: " + initialized);
        }
    }
    
    public static class AppConstants {
        public static final String APP_NAME;
        public static final String VERSION;
        public static final int MAX_CONNECTIONS;
        
        static {
            System.out.println("Initializing application constants...");
            APP_NAME = "MyApplication";
            VERSION = "2.1.0";
            MAX_CONNECTIONS = 100;
            System.out.println("Constants initialized");
        }
        
        public static void displayConstants() {
            System.out.println("=== Application Constants ===");
            System.out.println("App Name: " + APP_NAME);
            System.out.println("Version: " + VERSION);
            System.out.println("Max Connections: " + MAX_CONNECTIONS);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Static Initialization Demo ===");
        
        System.out.println("\nAccessing SystemConfig:");
        SystemConfig.displayConfiguration();
        
        System.out.println("\nAccessing AppConstants:");
        AppConstants.displayConstants();
        
        System.out.println("\nConfiguration status: " + SystemConfig.isInitialized());
    }
}