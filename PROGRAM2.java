import java.util.Arrays;

/**
 * Category C - Assignment Problem 2: The Playlist
 * 
 * Scenario:
 * A music app lets you build a playlist of songs.
 * 
 * Problem Statement:
 * Design a Playlist class that stores songs internally but returns a safe copy of the list, so nobody can sneak in changes from outside.
 * 
 * Requirements:
 * - Store song titles in a private array (assume a fixed maximum size).
 * - Provide a method to add a song, and one that returns all the songs added so far - as a copy, not the original array.
 * - Changing the array returned by that method must not affect the playlist's real contents.
 * - Provide a read-only count of how many songs are in the playlist.
 */
public class PROGRAM2 {

    static class Playlist {
        private final String[] songs;
        private int songCount;

        public Playlist(int maxSize) {
            this.songs = new String[maxSize];
            this.songCount = 0;
        }

        public void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            } else {
                System.out.println("Playlist is full.");
            }
        }

        public String[] getSongs() {
            // Return a safe copy of only the songs added so far
            return Arrays.copyOf(songs, songCount);
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing Playlist ===");
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Initial copy[0]: " + copy[0]);
        copy[0] = "Hacked";
        System.out.println("Modified copy[0]: " + copy[0]);

        System.out.println("Actual playlist song at index 0 after copy modification: " + p.getSongs()[0]);
        System.out.println("Total songs in playlist: " + p.getSongCount());
    }
}
