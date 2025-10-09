/*
Problem 6: Static Nested Class
Problem: "App Configuration"
*/

class AppConfig {
    private String appName;
    private String version;
    private static String company = "TechCorp";
    
    public AppConfig(String appName, String version) {
        this.appName = appName;
        this.version = version;
    }
    
    // Static Nested Class
    public static class NetworkConfig {
        private String host;
        private int port;
        private String protocol;
        
        public NetworkConfig(String host, int port, String protocol) {
            this.host = host;
            this.port = port;
            this.protocol = protocol;
        }
        
        // TODO: Display network config with optional access to app static members
        public void displayConfig() {
            System.out.println("=== Network Configuration ===");
            System.out.println("Company: " + company); // Can access static members of outer class
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("Protocol: " + protocol);
            System.out.println("Connection URL: " + protocol + "://" + host + ":" + port);
        }
        
        public boolean testConnection() {
            System.out.println("Testing connection to " + host + ":" + port);
            // Simulate connection test
            return port > 0 && host != null && !host.isEmpty();
        }
        
        public String getHost() { return host; }
        public int getPort() { return port; }
        public String getProtocol() { return protocol; }
        
        public void setHost(String host) { this.host = host; }
        public void setPort(int port) { this.port = port; }
        public void setProtocol(String protocol) { this.protocol = protocol; }
    }
    
    public void displayAppInfo() {
        System.out.println("=== Application Information ===");
        System.out.println("Company: " + company);
        System.out.println("App Name: " + appName);
        System.out.println("Version: " + version);
    }
    
    public String getAppName() { return appName; }
    public String getVersion() { return version; }
    public static String getCompany() { return company; }
}

public class AppConfigurator {
    public static void main(String[] args) {
        System.out.println("=== App Configuration System ===");
        
        // Create instance of NetworkConfig, print details
        AppConfig.NetworkConfig networkConfig = new AppConfig.NetworkConfig("api.example.com", 8080, "https");
        
        System.out.println("\n--- Network Configuration ---");
        networkConfig.displayConfig();
        
        System.out.println("\n--- Connection Test ---");
        boolean isConnected = networkConfig.testConnection();
        System.out.println("Connection Status: " + (isConnected ? "SUCCESS" : "FAILED"));
        
        // Create multiple network configurations
        System.out.println("\n--- Multiple Network Configs ---");
        AppConfig.NetworkConfig dbConfig = new AppConfig.NetworkConfig("db.example.com", 5432, "postgresql");
        AppConfig.NetworkConfig cacheConfig = new AppConfig.NetworkConfig("cache.example.com", 6379, "redis");
        
        AppConfig.NetworkConfig[] configs = {networkConfig, dbConfig, cacheConfig};
        
        for (AppConfig.NetworkConfig config : configs) {
            System.out.println("\nTesting " + config.getHost() + ":");
            config.displayConfig();
            System.out.println("Connection Test: " + (config.testConnection() ? "PASS" : "FAIL"));
        }
        
        // Create app instance to show relationship
        System.out.println("\n--- App Instance ---");
        AppConfig app = new AppConfig("MyApplication", "1.0.0");
        app.displayAppInfo();
        
        System.out.println("\n=== Static Nested Class Benefits ===");
        System.out.println("- NetworkConfig doesn't need AppConfig instance");
        System.out.println("- Can access static members of outer class");
        System.out.println("- Provides namespace organization");
        System.out.println("- Independent lifecycle from outer class");
    }
}