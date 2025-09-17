// Fitness Tracker System - Assignment Problem 5
import java.util.*;

class Exercise {
    private static int totalExercises = 0;
    private static Map<String, Integer> typeCount = new HashMap<>();
    
    private final String exerciseId;
    private String name;
    private String type;
    private int duration;
    private int caloriesBurned;
    private String difficulty;
    
    public Exercise(String name) {
        this(name, "General", 30, 100, "Medium");
    }
    
    public Exercise(String name, String type) {
        this(name, type, 45, 150, "Medium");
    }
    
    public Exercise(String name, String type, int duration) {
        this(name, type, duration, duration * 3, "Medium");
    }
    
    public Exercise(String name, String type, int duration, int calories, String difficulty) {
        this.exerciseId = "EX" + String.format("%04d", ++totalExercises);
        this.name = name;
        this.type = type;
        this.duration = Math.max(duration, 1);
        this.caloriesBurned = Math.max(calories, 1);
        this.difficulty = difficulty;
        
        typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        System.out.println("Exercise created: " + name + " (" + type + ") - " + duration + " min");
    }
    
    public static int getTotalExercises() { return totalExercises; }
    public static Map<String, Integer> getTypeCount() { return new HashMap<>(typeCount); }
    public static void displayExerciseStats() {
        System.out.println("=== Exercise Statistics ===");
        System.out.println("Total Exercises: " + totalExercises);
        System.out.println("Type Distribution:");
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public String getExerciseId() { return exerciseId; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getDuration() { return duration; }
    public int getCaloriesBurned() { return caloriesBurned; }
    public String getDifficulty() { return difficulty; }
}

class CardioExercise extends Exercise {
    private int heartRateZone;
    private double distance;
    
    public CardioExercise(String name) {
        super(name, "Cardio");
        this.heartRateZone = 3;
        this.distance = 2.0;
    }
    
    public CardioExercise(String name, int duration) {
        super(name, "Cardio", duration, duration * 8, "Medium");
        this.heartRateZone = duration > 30 ? 4 : 3;
        this.distance = duration * 0.1;
    }
    
    public CardioExercise(String name, int duration, double distance) {
        super(name, "Cardio", duration, (int)(distance * 100), "High");
        this.heartRateZone = 4;
        this.distance = distance;
    }
    
    public int getHeartRateZone() { return heartRateZone; }
    public double getDistance() { return distance; }
}

class StrengthExercise extends Exercise {
    private int sets;
    private int reps;
    private double weight;
    
    public StrengthExercise(String name) {
        super(name, "Strength");
        this.sets = 3;
        this.reps = 10;
        this.weight = 20.0;
    }
    
    public StrengthExercise(String name, int sets, int reps) {
        super(name, "Strength", sets * reps / 2, sets * reps * 2, "Medium");
        this.sets = sets;
        this.reps = reps;
        this.weight = 25.0;
    }
    
    public StrengthExercise(String name, int sets, int reps, double weight) {
        super(name, "Strength", sets * reps / 2, (int)(sets * reps * weight / 10), "High");
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }
    
    public int getSets() { return sets; }
    public int getReps() { return reps; }
    public double getWeight() { return weight; }
}

class FlexibilityExercise extends Exercise {
    private String targetMuscle;
    private boolean requiresEquipment;
    
    public FlexibilityExercise(String name) {
        super(name, "Flexibility", 15, 50, "Low");
        this.targetMuscle = "General";
        this.requiresEquipment = false;
    }
    
    public FlexibilityExercise(String name, String targetMuscle) {
        super(name, "Flexibility", 20, 60, "Low");
        this.targetMuscle = targetMuscle;
        this.requiresEquipment = false;
    }
    
    public FlexibilityExercise(String name, String targetMuscle, boolean requiresEquipment) {
        super(name, "Flexibility", 25, 70, "Medium");
        this.targetMuscle = targetMuscle;
        this.requiresEquipment = requiresEquipment;
    }
    
    public String getTargetMuscle() { return targetMuscle; }
    public boolean requiresEquipment() { return requiresEquipment; }
}

class FitnessUser {
    private static int totalUsers = 0;
    private static Map<String, Integer> goalCount = new HashMap<>();
    
    private final String userId;
    private String name;
    private int age;
    private double weight;
    private String fitnessGoal;
    private List<String> completedWorkouts;
    private int totalCaloriesBurned;
    
    public FitnessUser(String name) {
        this(name, 25, 70.0, "General Fitness");
    }
    
    public FitnessUser(String name, int age) {
        this(name, age, 70.0, "Weight Loss");
    }
    
    public FitnessUser(String name, int age, double weight) {
        this(name, age, weight, "Muscle Gain");
    }
    
    public FitnessUser(String name, int age, double weight, String fitnessGoal) {
        this.userId = "USER" + String.format("%04d", ++totalUsers);
        this.name = name;
        this.age = Math.max(age, 1);
        this.weight = Math.max(weight, 1.0);
        this.fitnessGoal = fitnessGoal;
        this.completedWorkouts = new ArrayList<>();
        this.totalCaloriesBurned = 0;
        
        goalCount.put(fitnessGoal, goalCount.getOrDefault(fitnessGoal, 0) + 1);
        System.out.println("User registered: " + name + " (Goal: " + fitnessGoal + ")");
    }
    
    public FitnessUser completeWorkout(Exercise exercise) {
        this.completedWorkouts.add(exercise.getName());
        this.totalCaloriesBurned += exercise.getCaloriesBurned();
        System.out.println(this.name + " completed: " + exercise.getName() + 
                         " (Burned " + exercise.getCaloriesBurned() + " calories)");
        return this;
    }
    
    public FitnessUser updateWeight(double newWeight) {
        this.weight = newWeight;
        System.out.println(this.name + " updated weight to: " + newWeight + " kg");
        return this;
    }
    
    public FitnessUser setGoal(String newGoal) {
        goalCount.put(this.fitnessGoal, goalCount.get(this.fitnessGoal) - 1);
        this.fitnessGoal = newGoal;
        goalCount.put(newGoal, goalCount.getOrDefault(newGoal, 0) + 1);
        System.out.println(this.name + " set new goal: " + newGoal);
        return this;
    }
    
    public static int getTotalUsers() { return totalUsers; }
    public static Map<String, Integer> getGoalCount() { return new HashMap<>(goalCount); }
    public static void displayUserStats() {
        System.out.println("=== User Statistics ===");
        System.out.println("Total Users: " + totalUsers);
        System.out.println("Goal Distribution:");
        for (Map.Entry<String, Integer> entry : goalCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public String getName() { return name; }
    public String getFitnessGoal() { return fitnessGoal; }
    public int getTotalCaloriesBurned() { return totalCaloriesBurned; }
    public List<String> getCompletedWorkouts() { return new ArrayList<>(completedWorkouts); }
}

class Workout {
    private static int totalWorkouts = 0;
    private static double totalCaloriesBurned = 0;
    
    private final String workoutId;
    private String name;
    private List<Object> exercises;
    private int totalDuration;
    private int estimatedCalories;
    private String difficulty;
    
    public Workout(String name) {
        this.workoutId = "WO" + String.format("%04d", ++totalWorkouts);
        this.name = name;
        this.exercises = new ArrayList<>();
        this.totalDuration = 0;
        this.estimatedCalories = 0;
        this.difficulty = "Medium";
        System.out.println("Workout created: " + name);
    }
    
    public Workout addExercise(Object exercise) {
        if (exercise instanceof Exercise) {
            Exercise ex = (Exercise) exercise;
            this.exercises.add(exercise);
            this.totalDuration += ex.getDuration();
            this.estimatedCalories += ex.getCaloriesBurned();
            System.out.println("Added " + ex.getName() + " to workout " + this.name);
        }
        return this;
    }
    
    public Workout removeExercise(Object exercise) {
        if (exercise instanceof Exercise && this.exercises.contains(exercise)) {
            Exercise ex = (Exercise) exercise;
            this.exercises.remove(exercise);
            this.totalDuration -= ex.getDuration();
            this.estimatedCalories -= ex.getCaloriesBurned();
            System.out.println("Removed " + ex.getName() + " from workout " + this.name);
        }
        return this;
    }
    
    public Workout setDifficulty(String difficulty) {
        this.difficulty = difficulty;
        System.out.println("Workout " + this.name + " difficulty set to: " + difficulty);
        return this;
    }
    
    public void executeWorkout(FitnessUser user) {
        System.out.println("\n=== " + user.getName() + " executing workout: " + this.name + " ===");
        for (Object obj : exercises) {
            if (obj instanceof Exercise) {
                Exercise exercise = (Exercise) obj;
                user.completeWorkout(exercise);
            }
        }
        totalCaloriesBurned += this.estimatedCalories;
        System.out.println("Workout completed! Total duration: " + this.totalDuration + " min");
    }
    
    public static int getTotalWorkouts() { return totalWorkouts; }
    public static double getTotalCaloriesBurned() { return totalCaloriesBurned; }
    public static void displayWorkoutStats() {
        System.out.println("=== Workout Statistics ===");
        System.out.println("Total Workouts Created: " + totalWorkouts);
        System.out.println("Total Calories Burned: " + String.format("%.0f", totalCaloriesBurned));
    }
    
    public String getName() { return name; }
    public int getTotalDuration() { return totalDuration; }
    public int getEstimatedCalories() { return estimatedCalories; }
    public List<Object> getExercises() { return new ArrayList<>(exercises); }
}

class FitnessSystem {
    private static final Map<String, Object> exerciseLibrary = new HashMap<>();
    private static final Map<String, Object> userProfiles = new HashMap<>();
    private static final List<Workout> workoutPlans = new ArrayList<>();
    
    public static void addExercise(Object exercise) {
        if (exercise instanceof Exercise) {
            Exercise ex = (Exercise) exercise;
            exerciseLibrary.put(ex.getExerciseId(), exercise);
        }
    }
    
    public static void registerUser(Object user) {
        if (user instanceof FitnessUser) {
            FitnessUser u = (FitnessUser) user;
            userProfiles.put(u.getName(), user);
        }
    }
    
    public static void processExercisesByType(String exerciseType) {
        System.out.println("\n=== Processing " + exerciseType + " Exercises ===");
        for (Object obj : exerciseLibrary.values()) {
            if (exerciseType.equals("Cardio") && obj instanceof CardioExercise) {
                CardioExercise cardio = (CardioExercise) obj;
                System.out.println("Cardio: " + cardio.getName() + " (Zone " + cardio.getHeartRateZone() + 
                                 ", Distance: " + cardio.getDistance() + " km)");
            } else if (exerciseType.equals("Strength") && obj instanceof StrengthExercise) {
                StrengthExercise strength = (StrengthExercise) obj;
                System.out.println("Strength: " + strength.getName() + " (" + strength.getSets() + 
                                 " sets x " + strength.getReps() + " reps @ " + strength.getWeight() + " kg)");
            } else if (exerciseType.equals("Flexibility") && obj instanceof FlexibilityExercise) {
                FlexibilityExercise flex = (FlexibilityExercise) obj;
                System.out.println("Flexibility: " + flex.getName() + " (Target: " + flex.getTargetMuscle() + 
                                 ", Equipment: " + flex.requiresEquipment() + ")");
            }
        }
    }
    
    public static void processUsersByGoal(String goal) {
        System.out.println("\n=== Processing Users with Goal: " + goal + " ===");
        for (Object obj : userProfiles.values()) {
            if (obj instanceof FitnessUser) {
                FitnessUser user = (FitnessUser) obj;
                if (user.getFitnessGoal().equals(goal)) {
                    System.out.println("User: " + user.getName() + " (Calories burned: " + 
                                     user.getTotalCaloriesBurned() + ", Workouts: " + 
                                     user.getCompletedWorkouts().size() + ")");
                }
            }
        }
    }
    
    public static void addWorkoutPlan(Workout workout) {
        workoutPlans.add(workout);
    }
    
    public static void displaySystemStats() {
        System.out.println("\n=== Fitness System Statistics ===");
        System.out.println("Exercise library: " + exerciseLibrary.size());
        System.out.println("Registered users: " + userProfiles.size());
        System.out.println("Workout plans: " + workoutPlans.size());
        Exercise.displayExerciseStats();
        FitnessUser.displayUserStats();
        Workout.displayWorkoutStats();
    }
}

public class FitnessTracker {
    public static void main(String[] args) {
        System.out.println("=== Fitness Tracker System ===");
        
        // Create different exercise types with constructor chaining
        CardioExercise cardio1 = new CardioExercise("Running");
        CardioExercise cardio2 = new CardioExercise("Cycling", 45, 15.0);
        StrengthExercise strength1 = new StrengthExercise("Push-ups");
        StrengthExercise strength2 = new StrengthExercise("Bench Press", 4, 8, 80.0);
        FlexibilityExercise flex1 = new FlexibilityExercise("Yoga");
        FlexibilityExercise flex2 = new FlexibilityExercise("Hamstring Stretch", "Hamstrings", true);
        
        // Add exercises to system
        FitnessSystem.addExercise(cardio1);
        FitnessSystem.addExercise(cardio2);
        FitnessSystem.addExercise(strength1);
        FitnessSystem.addExercise(strength2);
        FitnessSystem.addExercise(flex1);
        FitnessSystem.addExercise(flex2);
        
        // Create users with different constructor patterns
        FitnessUser user1 = new FitnessUser("John Doe");
        FitnessUser user2 = new FitnessUser("Jane Smith", 28, 65.0, "Weight Loss");
        FitnessUser user3 = new FitnessUser("Bob Wilson", 35, 80.0, "Muscle Gain");
        
        // Register users
        FitnessSystem.registerUser(user1);
        FitnessSystem.registerUser(user2);
        FitnessSystem.registerUser(user3);
        
        // Create workouts with method chaining
        System.out.println("\n=== Workout Creation Demo ===");
        Workout workout1 = new Workout("Morning Cardio")
            .addExercise(cardio1)
            .addExercise(flex1)
            .setDifficulty("Medium");
        
        Workout workout2 = new Workout("Strength Training")
            .addExercise(strength1)
            .addExercise(strength2)
            .addExercise(flex2)
            .setDifficulty("High");
        
        // Add workouts to system
        FitnessSystem.addWorkoutPlan(workout1);
        FitnessSystem.addWorkoutPlan(workout2);
        
        // Execute workouts
        workout1.executeWorkout(user1);
        workout2.executeWorkout(user2);
        
        // User interactions with method chaining
        user3.completeWorkout(cardio2)
             .completeWorkout(strength2)
             .updateWeight(78.0)
             .setGoal("Endurance");
        
        // Process exercises by type using instanceof
        FitnessSystem.processExercisesByType("Cardio");
        FitnessSystem.processExercisesByType("Strength");
        FitnessSystem.processExercisesByType("Flexibility");
        
        // Process users by goal
        FitnessSystem.processUsersByGoal("Weight Loss");
        FitnessSystem.processUsersByGoal("Muscle Gain");
        
        // Display system statistics
        FitnessSystem.displaySystemStats();
        
        // Test instanceof with mixed objects
        System.out.println("\n=== Type Testing ===");
        Object[] items = {cardio1, strength1, flex1, user1, workout1, "Not fitness related"};
        
        for (Object obj : items) {
            if (obj instanceof CardioExercise) {
                CardioExercise c = (CardioExercise) obj;
                System.out.println("✓ Cardio Exercise: " + c.getName() + " (Distance: " + c.getDistance() + " km)");
            } else if (obj instanceof StrengthExercise) {
                StrengthExercise s = (StrengthExercise) obj;
                System.out.println("✓ Strength Exercise: " + s.getName() + " (" + s.getWeight() + " kg)");
            } else if (obj instanceof FlexibilityExercise) {
                FlexibilityExercise f = (FlexibilityExercise) obj;
                System.out.println("✓ Flexibility Exercise: " + f.getName() + " (Target: " + f.getTargetMuscle() + ")");
            } else if (obj instanceof FitnessUser) {
                FitnessUser u = (FitnessUser) obj;
                System.out.println("✓ Fitness User: " + u.getName() + " (Goal: " + u.getFitnessGoal() + ")");
            } else if (obj instanceof Workout) {
                Workout w = (Workout) obj;
                System.out.println("✓ Workout: " + w.getName() + " (" + w.getTotalDuration() + " min)");
            } else {
                System.out.println("✗ Unknown item: " + obj);
            }
        }
    }
}