// File: WeatherAnalyzer.java
// ASSIGNMENT 7: Weather Data Analyzer

public class WeatherAnalyzer {
    
    public static class WeatherData {
        private double temperature;
        private double humidity;
        private static double totalTemp = 0;
        private static int readings = 0;
        
        public WeatherData(double temperature, double humidity) {
            this.temperature = temperature;
            this.humidity = humidity;
            totalTemp += temperature;
            readings++;
        }
        
        public static double getAverageTemperature() {
            return readings > 0 ? totalTemp / readings : 0;
        }
        
        public static String getWeatherCondition(double temp) {
            if (temp > 30) return "Hot";
            else if (temp > 20) return "Warm";
            else if (temp > 10) return "Cool";
            else return "Cold";
        }
        
        public void displayReading() {
            System.out.println("Temp: " + temperature + "°C, Humidity: " + humidity + "% - " + 
                             getWeatherCondition(temperature));
        }
        
        public static void displaySummary() {
            System.out.println("Total readings: " + readings);
            System.out.println("Average temperature: " + getAverageTemperature() + "°C");
        }
    }
    
    public static void main(String[] args) {
        WeatherData w1 = new WeatherData(25.5, 60);
        WeatherData w2 = new WeatherData(18.2, 75);
        WeatherData w3 = new WeatherData(32.1, 45);
        
        w1.displayReading();
        w2.displayReading();
        w3.displayReading();
        
        WeatherData.displaySummary();
    }
}