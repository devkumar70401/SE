import java.util.*;

class MusicPlaylist {
    public boolean isLongDuration(int duration) {
        return duration > 300; // Assuming a song longer than 5 minutes (300 seconds) is considered long
    }

    public void removeLongDurationSongs(LinkedHashMap<Integer, Song> playlist) {
        Iterator<Map.Entry<Integer, Song>> iterator = playlist.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Song> entry = iterator.next();
            if (isLongDuration(entry.getValue().getDuration())) {
                iterator.remove();
            }
        }
    }

    public void displayPlaylist(LinkedHashMap<Integer, Song> playlist) {
        for (Map.Entry<Integer, Song> entry : playlist.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}

class Song {
    private String title;
    private String artist;
    private int duration;
    private String genre;

    public Song(String title, String artist, int duration, String genre) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Artist: " + artist + ", Duration: " + duration + "s, Genre: " + genre;
    }
}

public class MusicPlayer {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Song> playlist = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for 5 songs (Title, Artist, Duration (seconds), Genre):");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Song " + i + ": ");
            String title = scanner.next();
            String artist = scanner.next();
            int duration = scanner.nextInt();
            String genre = scanner.next();
            playlist.put(i, new Song(title, artist, duration, genre));
        }
        MusicPlaylist musicPlayer = new MusicPlaylist();
        musicPlayer.removeLongDurationSongs(playlist);
        System.out.println("\nPlaylist after removing long duration songs:");
        musicPlayer.displayPlaylist(playlist);
        scanner.close();
    }
}

