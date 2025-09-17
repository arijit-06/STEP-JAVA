public class Workout {
    private String activityName;
    private int durationInMinutes;
    private int caloriesBurned;
    
    public Workout() {
        this.activityName = "Walking";
        this.durationInMinutes = 30;
        this.caloriesBurned = 100;
    }
    
    public Workout(String activityName) {
        this.activityName = activityName;
        this.durationInMinutes = 30;
        this.caloriesBurned = 150; // Default calories for custom activity
    }
    
    public Workout(String activityName, int durationInMinutes) {
        this.activityName = activityName;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = durationInMinutes * 5;
    }
    
    public void displayWorkout() {
        System.out.println("Activity: " + activityName + ", Duration: " + 
                          durationInMinutes + " mins, Calories Burned: " + caloriesBurned);
    }
    
    public static void main(String[] args) {
        System.out.println("=== FITNESS TRACKER ===\n");
        
        Workout w1 = new Workout();
        Workout w2 = new Workout("Running");
        Workout w3 = new Workout("Cycling", 45);
        Workout w4 = new Workout("Swimming", 60);
        
        System.out.println("Today's Workouts:");
        w1.displayWorkout();
        w2.displayWorkout();
        w3.displayWorkout();
        w4.displayWorkout();
        
        int totalCalories = 100 + 150 + (45*5) + (60*5);
        System.out.println("\nTotal calories burned today: " + totalCalories);
    }
}