package org.kure.example4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kure.example4.entities.SongImpl;
import org.kure.example4.shuffle.ShufflerFactory;
import org.kure.example4.shuffle.ShufflerType;
import org.kure.example4.storage.MusicStorage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MusicPlayerTest {
    private MusicStorage mockStorage;
    private ShufflerFactory factory;
    private MusicPlayer player;

    @BeforeEach
    public void setup() {
        // Mock the MusicStorage interface
        mockStorage = mock(MusicStorage.class);

        factory = new ShufflerFactory();

        // Stub the storage to return a fixed playlist
        when(mockStorage.loadSongs()).thenReturn(
                List.of(
                        new SongImpl("Song1", "Artist1", 1),
                        new SongImpl("Song2", "Artist2", 2),
                        new SongImpl("Song3", "Artist3", 3)
                )
        );

        // Initialize the MusicPlayer with the mocked storage
        player = new MusicPlayer(mockStorage);
    }

    @Test
    public void testPlayNextSong() {
        // Play two songs from the playlist
        player.playNextSong();
        player.playNextSong();

        // Verify the songs played are recorded in the play history
        List<Song> history = player.getPlayHistory();

        assertEquals(2, history.size(), "Play history should contain two songs.");
        assertEquals("Song1", history.get(0).getTitle(), "First song should be 'Song1'.");
        assertEquals("Song2", history.get(1).getTitle(), "Second song should be 'Song2'.");
    }

    @Test
    public void testEmptyPlaylistHandling() {
        // Play all songs
        player.playNextSong();
        player.playNextSong();
        player.playNextSong();

        // Try playing again with an empty playlist
        player.playNextSong();

        // Verify play history contains all songs, but no additional song is added
        List<Song> history = player.getPlayHistory();
        assertEquals(3, history.size(), "Play history should contain only the original songs.");
    }

    @Test
    public void testSavePlaylist() {
        // Add a new song to the playlist
        SongImpl newSong = new SongImpl("NewSong", "NewArtist", 200);
        player.addSongToPlaylist(newSong);

        // Save the current playlist
        player.savePlaylist();

        // Verify that the saveSongs method was called on the mocked storage
        verify(mockStorage, times(1)).saveSongs(any());
    }

    @Test
    public void testShufflerBackwardsDefault(){
        player.setShuffleMode(true);

        // Play all songs
        player.playNextSong();
        List<Song> playHistory = player.getPlayHistory();
        assertEquals(1, playHistory.size(), "Play history should contain one song.");
        assertEquals("Song3", playHistory.get(0).getTitle(), "First song should be 'Song3'.");
    }

    @Test
    void testCustomShuffler() {
        player.setShuffleMode(true);

        player.setRandomizer(factory.createRandomizer(ShufflerType.FORWARD));

        // Play all songs
        player.playNextSong();
        List<Song> playHistory = player.getPlayHistory();
        assertEquals(1, playHistory.size(), "Play history should contain one song.");
        assertEquals("Song1", playHistory.get(0).getTitle(), "First song should be 'Song1'.");
    }

}
