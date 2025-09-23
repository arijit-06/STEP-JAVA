// File: ConfigurationManager.java
// PRACTICE PROBLEM 4: Advanced Static Design Patterns

public class ConfigurationManager {
    
    public static class AppConfig {
        private static final String APP_NAME = "MyApplication";
        private static final String VERSION = "1.0.0";
        private static String environment;
        private static boolean debugMode;
        
        static {
            System.out.println("Loading application configuration...");
            environment = "development";
            debugMode = true;
            System.out.println("Configuration loaded successfully");
        }
        
        public static String getAppName() { return APP_NAME; }
        public static String getVersion() { return VERSION; }
        public static String getEnvironment() { return environment; }
        public static boolean isDebugMode() { return debugMode; }
        
        public static void setEnvironment(String env) {
            environment = env;
            debugMode = env.equals("development");
        }
        
        public static void displayConfig() {
            System.out.println("=== Application Configuration ===");
            System.out.println("App Name: " + APP_NAME);
            System.out.println("Version: " + VERSION);
            System.out.println("Environment: " + environment);
            System.out.println("Debug Mode: " + debugMode);
        }
    }
    
    public static class DatabaseConfig {
        private static String host = "localhost";
        private static int port = 3306;
        private static String database = "myapp";
        private static String username = "admin";
        
        public static String getConnectionString() {
            return String.format("jdbc:mysql://%s:%d/%s", host, port, database);
        }
        
        public static void updateConfig(String host, int port, String database) {
            DatabaseConfig.host = host;
            DatabaseConfig.port = port;
            DatabaseConfig.database = database;
        }
        
        public static void displayConfig() {
            System.out.println("=== Database Configuration ===");
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("Database: " + database);
            System.out.println("Connection String: " + getConnectionString());
        }
    }
    
    public static class Logger {
        private static boolean enabled = true;
        private static String logLevel = "INFO";
        
        public static void log(String message) {
            if (enabled) {
                System.out.println("[" + logLevel + "] " + message);
            }
        }
        
        public static void setLogLevel(String level) {
            logLevel = level;
        }
        
        public static void enable() { enabled = true; }
        public static void disable() { enabled = false; }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Configuration Manager Demo ===");
        
        AppConfig.displayConfig();
        DatabaseConfig.displayConfig();
        
        System.out.println("\n=== Testing Logger ===");
        Logger.log("Application started");
        Logger.setLogLevel("DEBUG");
        Logger.log("Debug message");
        
        System.out.println("\n=== Changing Environment ===");
        AppConfig.setEnvironment("production");
        AppConfig.displayConfig();
        
        System.out.println("\n=== Updating Database Config ===");
        DatabaseConfig.updateConfig("prod-server", 5432, "production_db");
        DatabaseConfig.displayConfig();
    }
}