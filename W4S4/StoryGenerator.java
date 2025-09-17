enum PersonalityType {
    BRAVE, SHY, FUNNY, MYSTERIOUS, EVIL
}

abstract class StoryCharacter {
    protected final String characterId;
    protected final String backstory;
    protected final PersonalityType corePersonality;
    protected String currentMood;
    protected String currentLocation;
    
    public static final String[] STORY_GENRES = {"Fantasy", "Sci-Fi", "Mystery", "Romance", "Adventure"};
    
    public StoryCharacter(String backstory, PersonalityType personality) {
        this.characterId = "CHAR-" + (int)(Math.random() * 10000);
        this.backstory = backstory;
        this.corePersonality = personality;
        this.currentMood = "Neutral";
        this.currentLocation = "Unknown";
    }
    
    public abstract String speak();
    public abstract String performAction();
}

class Hero extends StoryCharacter {
    private final String heroicAbility;
    
    public Hero(String backstory, String ability) {
        super(backstory, PersonalityType.BRAVE);
        this.heroicAbility = ability;
    }
    
    public String speak() {
        return "Hero says: 'Justice will prevail!' (Ability: " + heroicAbility + ")";
    }
    
    public String performAction() {
        return "Hero uses " + heroicAbility + " to save the day!";
    }
}

class Villain extends StoryCharacter {
    private final String evilMotivation;
    
    public Villain(String backstory, String motivation) {
        super(backstory, PersonalityType.EVIL);
        this.evilMotivation = motivation;
    }
    
    public String speak() {
        return "Villain laughs: 'My plan for " + evilMotivation + " cannot be stopped!'";
    }
    
    public String performAction() {
        return "Villain schemes for " + evilMotivation;
    }
}

class ComicRelief extends StoryCharacter {
    private final String humorStyle;
    
    public ComicRelief(String backstory, String humor) {
        super(backstory, PersonalityType.FUNNY);
        this.humorStyle = humor;
    }
    
    public String speak() {
        return "Comic Relief: *" + humorStyle + " joke* 'Why so serious?'";
    }
    
    public String performAction() {
        return "Makes everyone laugh with " + humorStyle + " humor";
    }
}

public class StoryGenerator {
    public static String generateStoryArc(StoryCharacter[] characters) {
        StringBuilder story = new StringBuilder("=== GENERATED STORY ===\n");
        
        for (StoryCharacter character : characters) {
            if (character instanceof Hero && hasVillain(characters)) {
                story.append("Epic battle between good and evil!\n");
            } else if (character instanceof ComicRelief) {
                story.append("Tension breaks with comic relief!\n");
            }
        }
        
        return story.toString();
    }
    
    private static boolean hasVillain(StoryCharacter[] characters) {
        for (StoryCharacter character : characters) {
            if (character instanceof Villain) return true;
        }
        return false;
    }
    
    public static String createDialogue(StoryCharacter character) {
        if (character instanceof Hero) {
            return "Heroic dialogue with noble intentions";
        } else if (character instanceof Villain) {
            return "Menacing dialogue with evil undertones";
        } else if (character instanceof ComicRelief) {
            return "Funny dialogue that lightens the mood";
        }
        return "Generic character dialogue";
    }
    
    public static void main(String[] args) {
        System.out.println("=== INTERACTIVE STORY GENERATOR ===");
        
        Hero hero = new Hero("Orphaned prince seeking justice", "Super Strength");
        Villain villain = new Villain("Former hero turned evil", "World Domination");
        ComicRelief comic = new ComicRelief("Bumbling sidekick", "Slapstick");
        
        StoryCharacter[] cast = {hero, villain, comic};
        
        System.out.println("Character Introductions:");
        for (StoryCharacter character : cast) {
            System.out.println(character.speak());
            System.out.println(character.performAction());
            System.out.println("Dialogue Style: " + createDialogue(character));
            System.out.println();
        }
        
        System.out.println(generateStoryArc(cast));
        
        System.out.println("Available Genres: ");
        for (String genre : StoryCharacter.STORY_GENRES) {
            System.out.println("- " + genre);
        }
    }
}