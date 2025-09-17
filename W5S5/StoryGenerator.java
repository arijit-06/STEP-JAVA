// Interactive Story Generator - Extra Practice Problem 4
import java.util.*;

final class CharacterDNA {
    private final String geneticId;
    private final String personalityType;
    private final String[] innateTalents;
    private final String characterArchetype;
    private final Map<String, Integer> baseAttributes;
    
    private CharacterDNA(String personalityType, String[] talents, String archetype, Map<String, Integer> attributes) {
        this.geneticId = "DNA" + System.currentTimeMillis();
        this.personalityType = personalityType;
        this.innateTalents = talents.clone();
        this.characterArchetype = archetype;
        this.baseAttributes = new HashMap<>(attributes);
    }
    
    public static CharacterDNA createRandomDNA() {
        String[] personalities = {"Brave", "Wise", "Cunning", "Kind"};
        String[] talents = {"Magic", "Combat", "Diplomacy"};
        String[] archetypes = {"Hero", "Villain", "Mentor", "Trickster"};
        Map<String, Integer> attrs = new HashMap<>();
        attrs.put("Strength", 50);
        attrs.put("Intelligence", 50);
        attrs.put("Charisma", 50);
        
        return new CharacterDNA(
            personalities[new Random().nextInt(personalities.length)],
            new String[]{talents[new Random().nextInt(talents.length)]},
            archetypes[new Random().nextInt(archetypes.length)],
            attrs
        );
    }
    
    public final boolean isCompatibleWith(CharacterDNA other) {
        return !this.characterArchetype.equals("Villain") || !other.characterArchetype.equals("Hero");
    }
    
    public String getPersonalityType() { return personalityType; }
    public String[] getInnateTalents() { return innateTalents.clone(); }
    public String getCharacterArchetype() { return characterArchetype; }
    public Map<String, Integer> getBaseAttributes() { return new HashMap<>(baseAttributes); }
}

class StoryCharacter {
    private final String characterId;
    private final CharacterDNA dna;
    private final long birthTimestamp;
    private String currentName;
    private String currentLocation;
    private String emotionalState;
    private final Map<String, String> relationships;
    private int experiencePoints;
    private Set<String> learnedSkills;
    
    static final String STORY_ENGINE_VERSION = "4.0";
    public static final String CHARACTER_SYSTEM_VERSION = "4.0";
    
    public StoryCharacter(CharacterDNA dna) {
        this(dna, "Unnamed Character", "Unknown Location", "Neutral");
    }
    
    public StoryCharacter(CharacterDNA dna, String name) {
        this(dna, name, "Starting Village", "Curious");
    }
    
    public StoryCharacter(CharacterDNA dna, String name, String startLocation, String mood) {
        this.characterId = "CHAR" + System.currentTimeMillis();
        this.dna = dna;
        this.birthTimestamp = System.currentTimeMillis();
        this.currentName = name;
        this.currentLocation = startLocation;
        this.emotionalState = mood;
        this.relationships = new HashMap<>();
        this.experiencePoints = 0;
        this.learnedSkills = new HashSet<>();
    }
    
    public String getCurrentName() { return currentName; }
    public String getCurrentLocation() { return currentLocation; }
    public CharacterDNA getDna() { return dna; }
    public int getExperiencePoints() { return experiencePoints; }
}

class HeroCharacter extends StoryCharacter {
    private final String destinyQuest;
    private String heroicVirtue;
    private Set<String> defeatedEnemies;
    
    public HeroCharacter(CharacterDNA dna, String name) {
        super(dna, name, "Hero's Village", "Determined");
        this.destinyQuest = "Save the World";
        this.heroicVirtue = "Courage";
        this.defeatedEnemies = new HashSet<>();
    }
    
    public HeroCharacter(CharacterDNA dna, String name, String quest) {
        super(dna, name, "Hero's Village", "Determined");
        this.destinyQuest = quest;
        this.heroicVirtue = "Justice";
        this.defeatedEnemies = new HashSet<>();
    }
    
    public String getDestinyQuest() { return destinyQuest; }
    public String getHeroicVirtue() { return heroicVirtue; }
}

class VillainCharacter extends StoryCharacter {
    private final String evilScheme;
    private final String corruptionSource;
    private int evilInfluence;
    
    public VillainCharacter(CharacterDNA dna, String name) {
        super(dna, name, "Dark Castle", "Malevolent");
        this.evilScheme = "Conquer the World";
        this.corruptionSource = "Dark Magic";
        this.evilInfluence = 100;
    }
    
    public VillainCharacter(CharacterDNA dna, String name, String scheme) {
        super(dna, name, "Dark Lair", "Scheming");
        this.evilScheme = scheme;
        this.corruptionSource = "Ancient Curse";
        this.evilInfluence = 75;
    }
    
    public String getEvilScheme() { return evilScheme; }
}

class MysteriousCharacter extends StoryCharacter {
    private String hiddenIdentity;
    private boolean identityRevealed;
    
    public MysteriousCharacter(CharacterDNA dna) {
        super(dna, "???", "Shadows", "Enigmatic");
        this.hiddenIdentity = "Secret Agent";
        this.identityRevealed = false;
    }
    
    public void revealIdentity() {
        if (!identityRevealed) {
            System.out.println("The mysterious character reveals: " + hiddenIdentity);
            identityRevealed = true;
        }
    }
}

class ComicCharacter extends StoryCharacter {
    private final String humorStyle;
    private int comedicTiming;
    
    public ComicCharacter(CharacterDNA dna, String name) {
        super(dna, name, "Comedy Club", "Cheerful");
        this.humorStyle = "Slapstick";
        this.comedicTiming = 80;
    }
    
    public ComicCharacter(CharacterDNA dna, String name, String style) {
        super(dna, name, "Stage", "Witty");
        this.humorStyle = style;
        this.comedicTiming = 90;
    }
    
    public String getHumorStyle() { return humorStyle; }
}

final class StoryEngine {
    private static final StoryEngine INSTANCE = new StoryEngine();
    private final Map<String, Object> activeCharacters;
    private final String[] narrativeRules;
    
    private StoryEngine() {
        this.activeCharacters = new HashMap<>();
        this.narrativeRules = new String[]{"Heroes must face challenges", "Villains create conflict"};
    }
    
    public static StoryEngine getInstance() {
        return INSTANCE;
    }
    
    public String generateStoryArc(List<Object> characters) {
        StringBuilder story = new StringBuilder("Story begins...\n");
        
        for (Object obj : characters) {
            if (obj instanceof HeroCharacter) {
                HeroCharacter hero = (HeroCharacter) obj;
                story.append(hero.getCurrentName()).append(" embarks on ").append(hero.getDestinyQuest()).append("\n");
            } else if (obj instanceof VillainCharacter) {
                VillainCharacter villain = (VillainCharacter) obj;
                story.append(villain.getCurrentName()).append(" plots ").append(villain.getEvilScheme()).append("\n");
            } else if (obj instanceof ComicCharacter) {
                ComicCharacter comic = (ComicCharacter) obj;
                story.append(comic.getCurrentName()).append(" provides ").append(comic.getHumorStyle()).append(" relief\n");
            } else if (obj instanceof MysteriousCharacter) {
                story.append("A mysterious figure watches from the shadows...\n");
            }
        }
        
        return story.toString();
    }
    
    public String resolveConflict(Object c1, Object c2) {
        if (c1 instanceof HeroCharacter && c2 instanceof VillainCharacter) {
            return "Epic battle between good and evil!";
        }
        if (c1 instanceof ComicCharacter && c2 instanceof VillainCharacter) {
            return "Comedy defeats evil with laughter!";
        }
        return "Characters interact peacefully";
    }
    
    public final String generateNarrative() {
        return "A tale of adventure, mystery, and heroism unfolds...";
    }
}

public class StoryGenerator {
    public static void main(String[] args) {
        System.out.println("=== Interactive Story Generator ===");
        
        // Create character DNA
        CharacterDNA heroDNA = CharacterDNA.createRandomDNA();
        CharacterDNA villainDNA = CharacterDNA.createRandomDNA();
        CharacterDNA comicDNA = CharacterDNA.createRandomDNA();
        
        // Create characters with different constructors
        HeroCharacter hero = new HeroCharacter(heroDNA, "Sir Galahad");
        VillainCharacter villain = new VillainCharacter(villainDNA, "Dark Lord Malice", "Steal all magic");
        ComicCharacter comic = new ComicCharacter(comicDNA, "Jester Bob", "Puns");
        MysteriousCharacter mystery = new MysteriousCharacter(CharacterDNA.createRandomDNA());
        
        // Test DNA compatibility
        System.out.println("Hero-Villain compatible: " + heroDNA.isCompatibleWith(villainDNA));
        System.out.println("Hero-Comic compatible: " + heroDNA.isCompatibleWith(comicDNA));
        
        // Create story using instanceof
        List<Object> characters = Arrays.asList(hero, villain, comic, mystery);
        StoryEngine engine = StoryEngine.getInstance();
        
        System.out.println("\n=== Generated Story ===");
        System.out.println(engine.generateStoryArc(characters));
        
        System.out.println("=== Character Conflicts ===");
        System.out.println(engine.resolveConflict(hero, villain));
        System.out.println(engine.resolveConflict(comic, villain));
        
        // Reveal mystery
        mystery.revealIdentity();
        
        System.out.println("\nFinal narrative: " + engine.generateNarrative());
    }
}