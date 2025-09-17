// Space Station Crew Management System - Extra Practice Problem 3
import java.util.*;

final class SecurityClearance {
    private final String clearanceId;
    private final String level;
    private final String[] authorizedSections;
    private final long expirationDate;
    
    public SecurityClearance(String level, String[] sections, long expiration) {
        this.clearanceId = "CLR" + System.currentTimeMillis();
        this.level = level;
        this.authorizedSections = sections.clone();
        this.expirationDate = expiration;
    }
    
    public final boolean canAccess(String section) {
        for (String authorized : authorizedSections) {
            if (authorized.equals(section)) return true;
        }
        return false;
    }
    
    public final boolean isExpired() {
        return System.currentTimeMillis() > expirationDate;
    }
    
    public final int getAccessHash() {
        return Arrays.hashCode(authorizedSections);
    }
    
    public String getLevel() { return level; }
    public String[] getAuthorizedSections() { return authorizedSections.clone(); }
}

final class CrewRank {
    private final String rankName;
    private final int level;
    private final String[] permissions;
    
    private CrewRank(String rankName, int level, String[] permissions) {
        this.rankName = rankName;
        this.level = level;
        this.permissions = permissions.clone();
    }
    
    public static CrewRank createCadet() {
        return new CrewRank("Cadet", 1, new String[]{"BasicAccess"});
    }
    
    public static CrewRank createOfficer() {
        return new CrewRank("Officer", 3, new String[]{"BasicAccess", "CrewQuarters"});
    }
    
    public static CrewRank createCommander() {
        return new CrewRank("Commander", 5, new String[]{"BasicAccess", "CrewQuarters", "Bridge"});
    }
    
    public String getRankName() { return rankName; }
    public int getLevel() { return level; }
    public String[] getPermissions() { return permissions.clone(); }
}

class SpaceCrew {
    private final String crewId;
    private final String homeplanet;
    private final SecurityClearance clearance;
    private final CrewRank initialRank;
    private CrewRank currentRank;
    private int missionCount;
    private double spaceHours;
    
    public static final String STATION_NAME = "Stellar Odyssey";
    public static final int MAX_CREW_CAPACITY = 50;
    
    public SpaceCrew(String name) {
        this(name, generateRandomPlanet(), CrewRank.createCadet(), 0, 0);
    }
    
    public SpaceCrew(String name, String homeplanet, CrewRank initialRank) {
        this(name, homeplanet, initialRank, 0, 0);
    }
    
    public SpaceCrew(String name, String homeplanet, CrewRank initialRank, int missions, double hours) {
        this.crewId = "CREW" + System.currentTimeMillis();
        this.homeplanet = homeplanet;
        this.initialRank = initialRank;
        this.currentRank = initialRank;
        this.missionCount = missions;
        this.spaceHours = hours;
        this.clearance = new SecurityClearance("Basic", new String[]{"Common"}, System.currentTimeMillis() + 31536000000L);
    }
    
    private static String generateRandomPlanet() {
        String[] planets = {"Earth", "Mars", "Venus", "Jupiter Station"};
        return planets[new Random().nextInt(planets.length)];
    }
    
    private boolean canAccessSection(String section) {
        return clearance.canAccess(section);
    }
    
    public final String getCrewIdentification() {
        return crewId + " - " + currentRank.getRankName();
    }
    
    public final boolean canBePromoted() {
        return missionCount > 5 && spaceHours > 100;
    }
    
    public final int calculateSecurityRating() {
        return currentRank.getLevel() * 10 + (int)(spaceHours / 10);
    }
    
    public String getCrewId() { return crewId; }
    public String getHomeplanet() { return homeplanet; }
    public CrewRank getCurrentRank() { return currentRank; }
    public int getMissionCount() { return missionCount; }
}

class CommandCrew extends SpaceCrew {
    private final Set<String> commandCertifications;
    
    public CommandCrew(String name, String homeplanet) {
        super(name, homeplanet, CrewRank.createCommander());
        this.commandCertifications = new HashSet<>();
        commandCertifications.add("Leadership");
        commandCertifications.add("Navigation");
    }
    
    public Set<String> getCommandCertifications() {
        return new HashSet<>(commandCertifications);
    }
}

class PilotCrew extends SpaceCrew {
    private final Set<String> flightCertifications;
    
    public PilotCrew(String name, String homeplanet) {
        super(name, homeplanet, CrewRank.createOfficer());
        this.flightCertifications = new HashSet<>();
        flightCertifications.add("Shuttle Pilot");
        flightCertifications.add("Navigation");
    }
}

class ScienceCrew extends SpaceCrew {
    private final String researchSpecialty;
    
    public ScienceCrew(String name, String homeplanet, String specialty) {
        super(name, homeplanet, CrewRank.createOfficer());
        this.researchSpecialty = specialty;
    }
    
    public String getResearchSpecialty() { return researchSpecialty; }
}

class EngineerCrew extends SpaceCrew {
    private final String engineeringType;
    
    public EngineerCrew(String name, String homeplanet, String type) {
        super(name, homeplanet, CrewRank.createOfficer());
        this.engineeringType = type;
    }
    
    public String getEngineeringType() { return engineeringType; }
}

final class SpaceStationRegistry {
    private static final Map<String, Object> crewRegistry = new HashMap<>();
    
    public static boolean registerCrew(Object crew) {
        if (crew instanceof SpaceCrew) {
            SpaceCrew c = (SpaceCrew) crew;
            crewRegistry.put(c.getCrewId(), crew);
            System.out.println("Registered crew: " + c.getCrewIdentification());
            return true;
        }
        return false;
    }
    
    public static List<Object> getCrewByType(String type) {
        List<Object> result = new ArrayList<>();
        for (Object crew : crewRegistry.values()) {
            if (type.equals("Command") && crew instanceof CommandCrew) {
                result.add(crew);
            } else if (type.equals("Pilot") && crew instanceof PilotCrew) {
                result.add(crew);
            } else if (type.equals("Science") && crew instanceof ScienceCrew) {
                result.add(crew);
            } else if (type.equals("Engineer") && crew instanceof EngineerCrew) {
                result.add(crew);
            }
        }
        return result;
    }
}

public class SpaceStation {
    public static void main(String[] args) {
        System.out.println("=== Space Station Crew Management ===");
        
        // Create different crew types
        CommandCrew commander = new CommandCrew("Captain Kirk", "Earth");
        PilotCrew pilot = new PilotCrew("Sulu", "Earth");
        ScienceCrew scientist = new ScienceCrew("Spock", "Vulcan", "Physics");
        EngineerCrew engineer = new EngineerCrew("Scotty", "Earth", "Warp Drive");
        
        // Register crew
        SpaceStationRegistry.registerCrew(commander);
        SpaceStationRegistry.registerCrew(pilot);
        SpaceStationRegistry.registerCrew(scientist);
        SpaceStationRegistry.registerCrew(engineer);
        
        // Test instanceof queries
        System.out.println("\nCommand crew: " + SpaceStationRegistry.getCrewByType("Command").size());
        System.out.println("Pilot crew: " + SpaceStationRegistry.getCrewByType("Pilot").size());
        System.out.println("Science crew: " + SpaceStationRegistry.getCrewByType("Science").size());
        System.out.println("Engineer crew: " + SpaceStationRegistry.getCrewByType("Engineer").size());
        
        // Test final methods
        System.out.println("\nCrew identifications:");
        System.out.println(commander.getCrewIdentification());
        System.out.println(pilot.getCrewIdentification());
        System.out.println("Can be promoted: " + commander.canBePromoted());
        System.out.println("Security rating: " + commander.calculateSecurityRating());
    }
}