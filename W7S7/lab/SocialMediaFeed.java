// LAB 2: Social Media Feed - Method Overriding
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Post {
    protected String author;
    protected String content;
    protected LocalDateTime timestamp;
    
    public Post(String author, String content) {
        this.author = author;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
    
    public void display() {
        System.out.println("Post by " + author + ": " + content + " at " + 
                         timestamp.format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}

class InstagramPost extends Post {
    private String hashtags;
    private int likes;
    
    public InstagramPost(String author, String content, String hashtags, int likes) {
        super(author, content);
        this.hashtags = hashtags;
        this.likes = likes;
    }
    
    @Override
    public void display() {
        System.out.println("📸 Instagram: @" + author + " - " + content + " " + hashtags);
        System.out.println("   ❤️ " + likes + " likes • " + timestamp.format(DateTimeFormatter.ofPattern("MMM dd, HH:mm")));
    }
}

class TwitterPost extends Post {
    private int retweets;
    private int characterCount;
    
    public TwitterPost(String author, String content, int retweets) {
        super(author, content);
        this.retweets = retweets;
        this.characterCount = content.length();
    }
    
    @Override
    public void display() {
        System.out.println("🐦 Twitter: @" + author + " - " + content);
        System.out.println("   🔄 " + retweets + " retweets • " + characterCount + " characters • " + 
                         timestamp.format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}

class LinkedInPost extends Post {
    private int connections;
    
    public LinkedInPost(String author, String content, int connections) {
        super(author, content);
        this.connections = connections;
    }
    
    @Override
    public void display() {
        System.out.println("💼 LinkedIn: " + author + " shared professional insight:");
        System.out.println("   \"" + content + "\"");
        System.out.println("   👥 Visible to " + connections + " connections • " + 
                         timestamp.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));
    }
}

public class SocialMediaFeed {
    public static void main(String[] args) {
        Post[] feed = {
            new InstagramPost("john_doe", "Beautiful sunset today!", "#sunset #nature #photography", 245),
            new TwitterPost("tech_guru", "Just discovered an amazing Java feature! Polymorphism is powerful.", 89),
            new LinkedInPost("Sarah Johnson", "Excited to share insights from today's tech conference on AI innovations.", 1250)
        };
        
        System.out.println("=== Social Media Feed ===");
        for (Post post : feed) {
            post.display();
            System.out.println();
        }
    }
}