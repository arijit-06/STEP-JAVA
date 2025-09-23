// File: DatabaseConnectionManager.java
// PRACTICE PROBLEM 2: Singleton Pattern and Static Factory Methods

public class DatabaseConnectionManager {
    
    // Singleton Database Connection
    public static class DatabaseConnection {
        private static DatabaseConnection instance;
        private String connectionString;
        private boolean isConnected;
        private static int connectionCount = 0;
        
        private DatabaseConnection() {
            this.connectionString = "jdbc:mysql://localhost:3306/testdb";
            this.isConnected = false;
            connectionCount++;
            System.out.println("Database connection instance created");
        }
        
        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }
        
        public void connect() {
            if (!isConnected) {
                isConnected = true;
                System.out.println("Connected to database: " + connectionString);
            } else {
                System.out.println("Already connected to database");
            }
        }
        
        public void disconnect() {
            if (isConnected) {
                isConnected = false;
                System.out.println("Disconnected from database");
            }
        }
        
        public static int getConnectionCount() {
            return connectionCount;
        }
    }
    
    // Static Factory for different database types
    public static class DatabaseFactory {
        public static DatabaseConnection createMySQLConnection() {
            DatabaseConnection conn = DatabaseConnection.getInstance();
            conn.connectionString = "jdbc:mysql://localhost:3306/mysql_db";
            return conn;
        }
        
        public static DatabaseConnection createPostgreSQLConnection() {
            DatabaseConnection conn = DatabaseConnection.getInstance();
            conn.connectionString = "jdbc:postgresql://localhost:5432/postgres_db";
            return conn;
        }
        
        public static DatabaseConnection createOracleConnection() {
            DatabaseConnection conn = DatabaseConnection.getInstance();
            conn.connectionString = "jdbc:oracle:thin:@localhost:1521:oracle_db";
            return conn;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demo ===");
        
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        DatabaseConnection conn2 = DatabaseConnection.getInstance();
        
        System.out.println("conn1 == conn2: " + (conn1 == conn2));
        System.out.println("Connection count: " + DatabaseConnection.getConnectionCount());
        
        System.out.println("\n=== Static Factory Methods ===");
        DatabaseConnection mysql = DatabaseFactory.createMySQLConnection();
        DatabaseConnection postgres = DatabaseFactory.createPostgreSQLConnection();
        
        mysql.connect();
        postgres.connect();
        
        System.out.println("Same instance: " + (mysql == postgres));
    }
}