// LAB 5: Movie Streaming Platform - Downcasting
class Content {
    protected String title;
    protected String genre;
    protected double rating;
    
    public Content(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }
    
    public void play() {
        System.out.println("▶️ Playing: " + title + " (" + genre + ") - Rating: " + rating);
    }
    
    public void pause() {
        System.out.println("⏸️ Paused: " + title);
    }
}

class Movie extends Content {
    private int duration;
    private String[] subtitles;
    
    public Movie(String title, String genre, double rating, int duration, String[] subtitles) {
        super(title, genre, rating);
        this.duration = duration;
        this.subtitles = subtitles;
    }
    
    public void showSubtitleOptions() {
        System.out.print("🎬 Subtitle options for " + title + ": ");
        for (String lang : subtitles) {
            System.out.print(lang + " ");
        }
        System.out.println();
    }
    
    public void showDuration() {
        System.out.println("⏱️ Duration: " + duration + " minutes");
    }
}

class TVSeries extends Content {
    private int seasons;
    private int currentEpisode;
    private String nextEpisode;
    
    public TVSeries(String title, String genre, double rating, int seasons, int currentEpisode, String nextEpisode) {
        super(title, genre, rating);
        this.seasons = seasons;
        this.currentEpisode = currentEpisode;
        this.nextEpisode = nextEpisode;
    }
    
    public void showNextEpisode() {
        System.out.println("📺 Next episode: " + nextEpisode + " (Season " + seasons + ", Episode " + (currentEpisode + 1) + ")");
    }
    
    public void showSeasonInfo() {
        System.out.println("📊 " + title + " has " + seasons + " seasons, currently on episode " + currentEpisode);
    }
}

class Documentary extends Content {
    private String[] educationalTags;
    private String[] relatedContent;
    
    public Documentary(String title, double rating, String[] educationalTags, String[] relatedContent) {
        super(title, "Documentary", rating);
        this.educationalTags = educationalTags;
        this.relatedContent = relatedContent;
    }
    
    public void showEducationalTags() {
        System.out.print("🎓 Educational tags: ");
        for (String tag : educationalTags) {
            System.out.print("#" + tag + " ");
        }
        System.out.println();
    }
    
    public void showRelatedContent() {
        System.out.print("🔗 Related content: ");
        for (String content : relatedContent) {
            System.out.print(content + " | ");
        }
        System.out.println();
    }
}

public class MovieStreamingPlatform {
    public static void main(String[] args) {
        Content[] watchlist = {
            new Movie("Avengers: Endgame", "Action", 8.4, 181, new String[]{"English", "Spanish", "French"}),
            new TVSeries("Stranger Things", "Sci-Fi", 8.7, 4, 8, "The Mind Flayer Returns"),
            new Documentary("Planet Earth", 9.4, new String[]{"Nature", "Wildlife", "Environment"}, 
                          new String[]{"Blue Planet", "Our Planet", "Life"})
        };
        
        System.out.println("=== Streaming Platform Demo ===");
        
        for (Content content : watchlist) {
            content.play();
            
            // Downcasting to access specific features
            if (content instanceof Movie) {
                Movie movie = (Movie) content;
                movie.showDuration();
                movie.showSubtitleOptions();
            } else if (content instanceof TVSeries) {
                TVSeries series = (TVSeries) content;
                series.showSeasonInfo();
                series.showNextEpisode();
            } else if (content instanceof Documentary) {
                Documentary doc = (Documentary) content;
                doc.showEducationalTags();
                doc.showRelatedContent();
            }
            
            content.pause();
            System.out.println();
        }
    }
}