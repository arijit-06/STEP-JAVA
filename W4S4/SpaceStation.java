enum CrewRank {
    CADET(1), OFFICER(2), COMMANDER(3), CAPTAIN(4), ADMIRAL(5);
    
    private final int level;
    
    CrewRank(int level) {
        this.level = level;
    }
    
    public int getLevel() {
        return level;
    }
}

class SpaceCrew {
    private final String crewId;
    private final String homeplanet;
    private final CrewRank initialRank;
    private CrewRank currentRank;
    private int skillLevel;
    private int missionCount;
    private int spaceHours;
    
    public static final String STATION_NAME = "Stellar Odyssey";
    public static final int MAX_CREW_CAPACITY = 50;
    
    public SpaceCrew(String name) {
        this.crewId = generateCrewId();
        this.homeplanet = generateRandomPlanet();
        this.initialRank = CrewRank.CADET;
        this.currentRank = CrewRank.CADET;
        this.skillLevel = 1;
        this.missionCount = 0;
        this.spaceHours = 0;
    }
    
    public SpaceCrew(String name, String homeplanet, CrewRank rank) {
        this.crewId = generateCrewId();
        this.homeplanet = homeplanet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.skillLevel = rank.getLevel() * 10;
        this.missionCount = 0;
        this.spaceHours = 0;
    }
    
    public SpaceCrew(String name, String homeplanet, CrewRank rank, int missions, int skills) {
        this.crewId = generateCrewId();
        this.homeplanet = homeplanet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.skillLevel = skills;
        this.missionCount = missions;
        this.spaceHours = missions * 100;
    }
    
    private String generateCrewId() {
        return "CREW-" + (int)(Math.random() * 10000);
    }
    
    private String generateRandomPlanet() {
        String[] planets = {"Earth", "Mars", "Venus", "Jupiter", "Saturn"};
        return planets[(int)(Math.random() * planets.length)];
    }
    
    public final String getCrewIdentification() {
        return crewId + " from " + homeplanet + " (Initial: " + initialRank + ")";
    }
    
    public final boolean canBePromoted() {
        return currentRank.getLevel() < CrewRank.ADMIRAL.getLevel() && 
               skillLevel >= currentRank.getLevel() * 20;
    }
    
    public final int calculateSpaceExperience() {
        return (missionCount * 10) + (spaceHours / 10) + (skillLevel * 2);
    }
    
    public void displayCrewInfo() {
        System.out.println("ID: " + getCrewIdentification());
        System.out.println("Current Rank: " + currentRank + ", Skill: " + skillLevel);
        System.out.println("Missions: " + missionCount + ", Space Hours: " + spaceHours);
        System.out.println("Experience Score: " + calculateSpaceExperience());
        System.out.println("Can be promoted: " + canBePromoted());
    }
}

public final class SpaceStation {
    public static void main(String[] args) {
        System.out.println("=== " + SpaceCrew.STATION_NAME + " CREW MANAGEMENT ===");
        
        SpaceCrew crew1 = new SpaceCrew("John");
        SpaceCrew crew2 = new SpaceCrew("Alice", "Mars", CrewRank.OFFICER);
        SpaceCrew crew3 = new SpaceCrew("Bob", "Earth", CrewRank.COMMANDER, 15, 45);
        
        System.out.println("Crew Member 1:");
        crew1.displayCrewInfo();
        
        System.out.println("\nCrew Member 2:");
        crew2.displayCrewInfo();
        
        System.out.println("\nCrew Member 3:");
        crew3.displayCrewInfo();
        
        System.out.println("\nStation Capacity: " + SpaceCrew.MAX_CREW_CAPACITY);
    }
}