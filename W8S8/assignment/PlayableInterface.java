/*
Topic 2: Interface Implementation in Multiple Classes
Problem Statement:
Create an interface Playable with methods play() and pause().
Create two classes MusicPlayer and VideoPlayer that implement this interface.
Demonstrate polymorphism by storing objects in a Playable reference and invoking methods.
Hints:
● Use interface keyword.
● Implement both methods in each class.
● Use Playable ref = new MusicPlayer(); to test polymorphism.
*/

interface Playable {
    void play();
    void pause();
    
    default void stop() {
        System.out.println("Stopping playback...");
    }
    
    default void showPlayerInfo() {
        System.out.println("This is a media player device");
    }
    
    static void mediaPlayerGuidelines() {
        System.out.println("Media Player Guidelines:");
        System.out.println("- Always check media format compatibility");
        System.out.println("- Ensure sufficient storage space");
        System.out.println("- Use appropriate volume levels");
        System.out.println("- Regular software updates recommended");
    }
}

class MusicPlayer implements Playable {
    private String currentSong;
    private String artist;
    private boolean isPlaying;
    private boolean isPaused;
    private int volume;
    private String[] playlist;
    private int currentTrack;
    
    public MusicPlayer() {
        this.currentSong = "No song loaded";
        this.artist = "Unknown";
        this.isPlaying = false;
        this.isPaused = false;
        this.volume = 50;
        this.playlist = new String[0];
        this.currentTrack = 0;
    }
    
    public MusicPlayer(String[] playlist) {
        this();
        this.playlist = playlist;
        if (playlist.length > 0) {
            this.currentSong = playlist[0];
            this.artist = "Various Artists";
        }
    }
    
    @Override
    public void play() {
        if (isPaused) {
            System.out.println("\n🎵 Resuming music playback...");
            System.out.println("♪ Now playing: " + currentSong);
            if (!artist.equals("Unknown")) {
                System.out.println("Artist: " + artist);
            }
            isPaused = false;
            isPlaying = true;
        } else if (!isPlaying) {
            System.out.println("\n🎵 Starting music playback...");
            System.out.println("♪ Now playing: " + currentSong);
            if (!artist.equals("Unknown")) {
                System.out.println("Artist: " + artist);
            }
            System.out.println("Volume: " + volume + "%");
            isPlaying = true;
        } else {
            System.out.println("Music is already playing");
        }
    }
    
    @Override
    public void pause() {
        if (isPlaying && !isPaused) {
            System.out.println("\n⏸️ Music paused");
            System.out.println("Current song: " + currentSong);
            isPaused = true;
            isPlaying = false;
        } else if (isPaused) {
            System.out.println("Music is already paused");
        } else {
            System.out.println("No music is currently playing");
        }
    }
    
    @Override
    public void stop() {
        if (isPlaying || isPaused) {
            System.out.println("\n⏹️ Music stopped");
            System.out.println("Stopped: " + currentSong);
            isPlaying = false;
            isPaused = false;
        } else {
            System.out.println("No music is currently playing");
        }
    }
    
    @Override
    public void showPlayerInfo() {
        System.out.println("\n=== Music Player Information ===");
        System.out.println("Device Type: Music Player");
        System.out.println("Current Song: " + currentSong);
        System.out.println("Artist: " + artist);
        System.out.println("Volume: " + volume + "%");
        System.out.println("Status: " + getStatus());
        System.out.println("Playlist Size: " + playlist.length + " songs");
        System.out.println("Current Track: " + (currentTrack + 1) + "/" + playlist.length);
    }
    
    public void loadSong(String song, String artist) {
        this.currentSong = song;
        this.artist = artist;
        System.out.println("🎵 Loaded: " + song + " by " + artist);
    }
    
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("🔊 Volume set to " + volume + "%");
        } else {
            System.out.println("Invalid volume level. Use 0-100");
        }
    }
    
    public void nextTrack() {
        if (playlist.length > 0) {
            currentTrack = (currentTrack + 1) % playlist.length;
            currentSong = playlist[currentTrack];
            System.out.println("⏭️ Next track: " + currentSong);
            if (isPlaying) {
                play();
            }
        } else {
            System.out.println("No playlist available");
        }
    }
    
    public void previousTrack() {
        if (playlist.length > 0) {
            currentTrack = (currentTrack - 1 + playlist.length) % playlist.length;
            currentSong = playlist[currentTrack];
            System.out.println("⏮️ Previous track: " + currentSong);
            if (isPlaying) {
                play();
            }
        } else {
            System.out.println("No playlist available");
        }
    }
    
    private String getStatus() {
        if (isPlaying) return "Playing";
        if (isPaused) return "Paused";
        return "Stopped";
    }
    
    public boolean isPlaying() { return isPlaying; }
    public String getCurrentSong() { return currentSong; }
}

class VideoPlayer implements Playable {
    private String currentVideo;
    private String resolution;
    private boolean isPlaying;
    private boolean isPaused;
    private int brightness;
    private String[] videoLibrary;
    private int currentVideoIndex;
    
    public VideoPlayer() {
        this.currentVideo = "No video loaded";
        this.resolution = "1080p";
        this.isPlaying = false;
        this.isPaused = false;
        this.brightness = 75;
        this.videoLibrary = new String[0];
        this.currentVideoIndex = 0;
    }
    
    public VideoPlayer(String[] videoLibrary) {
        this();
        this.videoLibrary = videoLibrary;
        if (videoLibrary.length > 0) {
            this.currentVideo = videoLibrary[0];
        }
    }
    
    @Override
    public void play() {
        if (isPaused) {
            System.out.println("\n🎬 Resuming video playback...");
            System.out.println("📺 Now playing: " + currentVideo);
            System.out.println("Resolution: " + resolution);
            isPaused = false;
            isPlaying = true;
        } else if (!isPlaying) {
            System.out.println("\n🎬 Starting video playback...");
            System.out.println("📺 Now playing: " + currentVideo);
            System.out.println("Resolution: " + resolution);
            System.out.println("Brightness: " + brightness + "%");
            isPlaying = true;
        } else {
            System.out.println("Video is already playing");
        }
    }
    
    @Override
    public void pause() {
        if (isPlaying && !isPaused) {
            System.out.println("\n⏸️ Video paused");
            System.out.println("Current video: " + currentVideo);
            isPaused = true;
            isPlaying = false;
        } else if (isPaused) {
            System.out.println("Video is already paused");
        } else {
            System.out.println("No video is currently playing");
        }
    }
    
    @Override
    public void stop() {
        if (isPlaying || isPaused) {
            System.out.println("\n⏹️ Video stopped");
            System.out.println("Stopped: " + currentVideo);
            isPlaying = false;
            isPaused = false;
        } else {
            System.out.println("No video is currently playing");
        }
    }
    
    @Override
    public void showPlayerInfo() {
        System.out.println("\n=== Video Player Information ===");
        System.out.println("Device Type: Video Player");
        System.out.println("Current Video: " + currentVideo);
        System.out.println("Resolution: " + resolution);
        System.out.println("Brightness: " + brightness + "%");
        System.out.println("Status: " + getStatus());
        System.out.println("Video Library: " + videoLibrary.length + " videos");
        System.out.println("Current Video: " + (currentVideoIndex + 1) + "/" + videoLibrary.length);
    }
    
    public void loadVideo(String video) {
        this.currentVideo = video;
        System.out.println("🎬 Loaded: " + video);
    }
    
    public void setResolution(String resolution) {
        this.resolution = resolution;
        System.out.println("📺 Resolution set to " + resolution);
    }
    
    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
            System.out.println("🔆 Brightness set to " + brightness + "%");
        } else {
            System.out.println("Invalid brightness level. Use 0-100");
        }
    }
    
    public void nextVideo() {
        if (videoLibrary.length > 0) {
            currentVideoIndex = (currentVideoIndex + 1) % videoLibrary.length;
            currentVideo = videoLibrary[currentVideoIndex];
            System.out.println("⏭️ Next video: " + currentVideo);
            if (isPlaying) {
                play();
            }
        } else {
            System.out.println("No video library available");
        }
    }
    
    public void fullScreen() {
        System.out.println("🖥️ Switching to full screen mode");
        System.out.println("Video: " + currentVideo + " now in full screen");
    }
    
    private String getStatus() {
        if (isPlaying) return "Playing";
        if (isPaused) return "Paused";
        return "Stopped";
    }
    
    public boolean isPlaying() { return isPlaying; }
    public String getCurrentVideo() { return currentVideo; }
}

public class PlayableInterface {
    public static void main(String[] args) {
        System.out.println("=== Interface Implementation in Multiple Classes Demo ===");
        
        Playable.mediaPlayerGuidelines();
        
        String[] musicPlaylist = {"Bohemian Rhapsody", "Stairway to Heaven", "Hotel California", "Sweet Child O' Mine"};
        String[] videoLibrary = {"The Matrix", "Inception", "Interstellar", "Avatar"};
        
        MusicPlayer musicPlayer = new MusicPlayer(musicPlaylist);
        VideoPlayer videoPlayer = new VideoPlayer(videoLibrary);
        
        System.out.println("\n=== Music Player Demo ===");
        musicPlayer.loadSong("Bohemian Rhapsody", "Queen");
        musicPlayer.showPlayerInfo();
        musicPlayer.play();
        musicPlayer.setVolume(80);
        musicPlayer.pause();
        musicPlayer.play();
        musicPlayer.nextTrack();
        musicPlayer.stop();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n=== Video Player Demo ===");
        videoPlayer.loadVideo("The Matrix");
        videoPlayer.showPlayerInfo();
        videoPlayer.play();
        videoPlayer.setResolution("4K");
        videoPlayer.setBrightness(90);
        videoPlayer.pause();
        videoPlayer.play();
        videoPlayer.fullScreen();
        videoPlayer.nextVideo();
        videoPlayer.stop();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n=== Polymorphic Behavior Demo ===");
        
        // Using Playable references - demonstrating polymorphism
        Playable music = new MusicPlayer();
        Playable video = new VideoPlayer();
        
        music.showPlayerInfo();
        video.showPlayerInfo();
        
        System.out.println("\nTesting polymorphic play/pause operations:");
        Playable[] players = {music, video};
        
        for (Playable player : players) {
            System.out.println("\n--- Testing " + player.getClass().getSimpleName() + " ---");
            player.play();
            player.pause();
            player.stop();
        }
        
        System.out.println("\n=== Advanced Polymorphic Demo ===");
        Playable[] mediaPlayers = {musicPlayer, videoPlayer};
        
        System.out.println("Starting all media players:");
        for (Playable player : mediaPlayers) {
            player.play();
        }
        
        System.out.println("\nPausing all media players:");
        for (Playable player : mediaPlayers) {
            player.pause();
        }
        
        System.out.println("\nStopping all media players:");
        for (Playable player : mediaPlayers) {
            player.stop();
        }
        
        System.out.println("\n=== Media Player Status Summary ===");
        System.out.println("Music Player - Current: " + musicPlayer.getCurrentSong() + 
            ", Status: " + (musicPlayer.isPlaying() ? "Playing" : "Stopped"));
        System.out.println("Video Player - Current: " + videoPlayer.getCurrentVideo() + 
            ", Status: " + (videoPlayer.isPlaying() ? "Playing" : "Stopped"));
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Playable interface defines common media player contract");
        System.out.println("2. MusicPlayer and VideoPlayer implement interface differently");
        System.out.println("3. Polymorphism allows uniform handling of different players");
        System.out.println("4. Interface references can call implemented methods");
        System.out.println("5. Default methods provide additional functionality");
        System.out.println("6. Static methods offer utility functions");
    }
}