// File: CompleteInheritanceSystem.java
// ASSIGNMENT 6: Weather System Hierarchy

public class CompleteInheritanceSystem {
    
    // Base class Weather
    public static class Weather {
        protected String location;
        protected double temperature;
        protected double humidity;
        protected String condition;
        
        public Weather(String location, double temperature, double humidity, String condition) {
            this.location = location;
            this.temperature = temperature;
            this.humidity = humidity;
            this.condition = condition;
            System.out.println("Weather constructor: " + condition + " in " + location);
        }
        
        public void displayWeather() {
            System.out.println("Weather in " + location + ": " + condition);
            System.out.println("Temperature: " + temperature + "°C, Humidity: " + humidity + "%");
        }
        
        public void forecast() {
            System.out.println("General weather forecast for " + location);
        }
        
        public String getCondition() { return condition; }
        public String getLocation() { return location; }
    }
    
    // Multilevel inheritance: Weather → Storm → Thunderstorm
    public static class Storm extends Weather {
        protected double windSpeed;
        protected String stormType;
        
        public Storm(String location, double temperature, double humidity, 
                    double windSpeed, String stormType) {
            super(location, temperature, humidity, "Stormy");
            this.windSpeed = windSpeed;
            this.stormType = stormType;
            System.out.println("Storm constructor: " + stormType + " storm");
        }
        
        @Override
        public void displayWeather() {
            super.displayWeather();
            System.out.println("Storm type: " + stormType + ", Wind speed: " + windSpeed + " km/h");
        }
        
        @Override
        public void forecast() {
            System.out.println("Storm warning for " + location + ": " + stormType + " storm approaching");
            System.out.println("Expected wind speeds: " + windSpeed + " km/h");
        }
        
        public void issueWarning() {
            System.out.println("⚠️ STORM WARNING: " + stormType + " storm in " + location);
        }
    }
    
    public static class Thunderstorm extends Storm {
        private int lightningStrikes;
        private boolean hailExpected;
        
        public Thunderstorm(String location, double temperature, double humidity, 
                           double windSpeed, int lightningStrikes, boolean hailExpected) {
            super(location, temperature, humidity, windSpeed, "Thunderstorm");
            this.lightningStrikes = lightningStrikes;
            this.hailExpected = hailExpected;
            System.out.println("Thunderstorm constructor: " + lightningStrikes + " strikes expected");
        }
        
        @Override
        public void displayWeather() {
            super.displayWeather();
            System.out.println("Lightning strikes: " + lightningStrikes + "/hour");
            System.out.println("Hail expected: " + (hailExpected ? "Yes" : "No"));
        }
        
        @Override
        public void forecast() {
            super.forecast();
            System.out.println("Severe thunderstorm with " + lightningStrikes + " lightning strikes per hour");
            if (hailExpected) {
                System.out.println("Hail warning in effect");
            }
        }
        
        @Override
        public void issueWarning() {
            System.out.println("🌩️ SEVERE THUNDERSTORM WARNING: " + location);
            System.out.println("Lightning strikes: " + lightningStrikes + "/hour");
            if (hailExpected) {
                System.out.println("HAIL WARNING: Seek shelter immediately");
            }
        }
        
        public void lightningAlert() {
            System.out.println("⚡ Lightning detected in " + location + " - Stay indoors!");
        }
    }
    
    // Hierarchical inheritance: Weather → Sunshine
    public static class Sunshine extends Weather {
        private int uvIndex;
        private double visibility;
        
        public Sunshine(String location, double temperature, double humidity, 
                       int uvIndex, double visibility) {
            super(location, temperature, humidity, "Sunny");
            this.uvIndex = uvIndex;
            this.visibility = visibility;
            System.out.println("Sunshine constructor: UV index " + uvIndex);
        }
        
        @Override
        public void displayWeather() {
            super.displayWeather();
            System.out.println("UV Index: " + uvIndex + ", Visibility: " + visibility + " km");
        }
        
        @Override
        public void forecast() {
            System.out.println("Sunny weather forecast for " + location);
            System.out.println("Perfect day for outdoor activities!");
            if (uvIndex > 7) {
                System.out.println("High UV index - use sunscreen");
            }
        }
        
        public void sunProtectionAdvice() {
            if (uvIndex > 7) {
                System.out.println("☀️ High UV warning: Use SPF 30+ sunscreen");
            } else if (uvIndex > 3) {
                System.out.println("☀️ Moderate UV: Consider sun protection");
            } else {
                System.out.println("☀️ Low UV: Minimal sun protection needed");
            }
        }
    }
    
    // Another hierarchical branch: Weather → Rainy
    public static class Rainy extends Weather {
        private double rainfall;
        private String intensity;
        
        public Rainy(String location, double temperature, double humidity, 
                    double rainfall, String intensity) {
            super(location, temperature, humidity, "Rainy");
            this.rainfall = rainfall;
            this.intensity = intensity;
            System.out.println("Rainy constructor: " + intensity + " rain");
        }
        
        @Override
        public void displayWeather() {
            super.displayWeather();
            System.out.println("Rainfall: " + rainfall + " mm, Intensity: " + intensity);
        }
        
        @Override
        public void forecast() {
            System.out.println("Rainy weather forecast for " + location);
            System.out.println("Expected rainfall: " + rainfall + " mm (" + intensity + ")");
        }
        
        public void floodWarning() {
            if (rainfall > 50) {
                System.out.println("🌧️ FLOOD WARNING: Heavy rainfall expected in " + location);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Complete Inheritance System Demo ===");
        
        // Create weather objects demonstrating both inheritance patterns
        Weather[] weatherConditions = {
            new Sunshine("Miami", 28, 65, 8, 15),
            new Rainy("Seattle", 15, 85, 25, "Moderate"),
            new Storm("Chicago", 12, 75, 45, "Winter"),
            new Thunderstorm("Dallas", 22, 80, 65, 15, true)
        };
        
        System.out.println("\n=== Weather Reports ===");
        for (Weather weather : weatherConditions) {
            weather.displayWeather();
            System.out.println();
        }
        
        System.out.println("=== Weather Forecasts ===");
        for (Weather weather : weatherConditions) {
            weather.forecast();
            System.out.println();
        }
        
        System.out.println("=== Type-specific Methods ===");
        for (Weather weather : weatherConditions) {
            if (weather instanceof Thunderstorm) {
                Thunderstorm ts = (Thunderstorm) weather;
                ts.issueWarning();
                ts.lightningAlert();
            } else if (weather instanceof Storm) {
                ((Storm) weather).issueWarning();
            } else if (weather instanceof Sunshine) {
                ((Sunshine) weather).sunProtectionAdvice();
            } else if (weather instanceof Rainy) {
                ((Rainy) weather).floodWarning();
            }
            System.out.println();
        }
        
        System.out.println("=== Inheritance Relationships ===");
        Thunderstorm severeTstorm = new Thunderstorm("Houston", 25, 90, 80, 25, true);
        
        System.out.println("instanceof tests:");
        System.out.println("Thunderstorm instanceof Weather: " + (severeTstorm instanceof Weather));
        System.out.println("Thunderstorm instanceof Storm: " + (severeTstorm instanceof Storm));
        System.out.println("Thunderstorm instanceof Thunderstorm: " + (severeTstorm instanceof Thunderstorm));
        
        System.out.println("\n=== Polymorphic Array Processing ===");
        Weather polymorphicWeather = new Thunderstorm("Austin", 20, 85, 70, 20, false);
        polymorphicWeather.displayWeather(); // Calls Thunderstorm's overridden method
        polymorphicWeather.forecast(); // Calls Thunderstorm's overridden method
        
        System.out.println("\n=== Inheritance Pattern Summary ===");
        System.out.println("✓ Multilevel: Weather → Storm → Thunderstorm");
        System.out.println("✓ Hierarchical: Weather → Sunshine, Weather → Rainy");
        System.out.println("✓ Constructor chaining through all levels");
        System.out.println("✓ Method overriding at multiple levels");
        System.out.println("✓ Polymorphic behavior with arrays");
    }
}