package org.kure.example4;

import org.kure.example4.listener.MusicPlayerEventListener;
import org.kure.example4.shuffle.BackwardShuffler;
import org.kure.example4.shuffle.Shuffler;
import org.kure.example4.storage.MusicStorage;

import java.util.*;

public class MusicPlayer {
    private final MusicStorage<Song> storage;
    private final LinkedList<Song> playlist;
    private final Deque<Song> playHistory;
    private boolean shuffleMode;
    private boolean repeatMode;
    private MusicPlayerEventListener eventListener;
    private Shuffler<Song> shuffler;

    public MusicPlayer(MusicStorage<Song> storage) {
        this.storage = storage;
        this.playlist = new LinkedList<>(storage.loadSongs());
        this.playHistory = new ArrayDeque<>();
        this.shuffleMode = false;
        this.repeatMode = false;
        this.shuffler = new BackwardShuffler();
    }

    public void setEventListener(MusicPlayerEventListener listener) {
        this.eventListener = listener;
    }

    public void setRandomizer(Shuffler<Song> shuffler) {
        this.shuffler = shuffler;
    }

    public void setShuffleMode(boolean shuffleMode) {
        this.shuffleMode = shuffleMode;
        System.out.println("Shuffle mode: " + (shuffleMode ? "ON" : "OFF"));
    }

    public void setRepeatMode(boolean repeatMode) {
        this.repeatMode = repeatMode;
        System.out.println("Repeat mode: " + (repeatMode ? "ON" : "OFF"));
    }

    public void playNextSong() {
        if (playlist.isEmpty() && !repeatMode) {
            System.out.println("Playlist is empty.");
            if (eventListener != null) {
                eventListener.onPlaylistEmpty();
            }
            return;
        }

        Song song;

        if (shuffleMode) {
            List<Song> songList = new ArrayList<>(playlist);
            song = shuffler.getSong(songList);
            playlist.remove(song);
        } else {
            song = playlist.poll();
        }

        if (song != null) {
            playHistory.push(song); // Add to history
            System.out.println("Now playing: " + song);
            if (eventListener != null) {
                eventListener.onSongStarted(song);
            }

            listen(song);
        }

        if (repeatMode && song != null) {
            playlist.addFirst(song); // Add song back to the queue
        }
    }

    // Modify simulateSongPlayback to be easier to mock in tests
    protected void listen(Song song) {
        int duration = song.getDuration();
        for (int i = 1; i <= duration; i++) {
            try {
                Thread.sleep(1); // Simulates 1 second of playback, but it's faster
                System.out.print("\rProgress: " + i + "/" + duration + "s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addSongToPlaylist(Song song) {
        playlist.add(song);
        System.out.println("Added to playlist: " + song);
    }

    public void savePlaylist() {
        storage.saveSongs(new LinkedList<>(playlist));
        System.out.println("Playlist saved.");
    }

    // Add this getter for testing purposes
    public List<Song> getPlayHistory() {
        return new ArrayList<>(playHistory);
    }

}
