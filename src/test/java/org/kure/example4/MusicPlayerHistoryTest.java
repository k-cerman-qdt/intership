package org.kure.example4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kure.example4.entities.SongImpl;
import org.kure.example4.storage.MusicStorage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MusicPlayerHistoryTest {
    private MusicPlayer player;

    @BeforeEach
    public void setup() {
        MusicStorage mockStorage = mock(MusicStorage.class);
        when(mockStorage.loadSongs()).thenReturn(
                List.of(new SongImpl("Song1", "Artist1", 1),
                        new SongImpl("Song2", "Artist2", 2)
                )
        );

        player = new MusicPlayer(mockStorage);
    }

    @Test
    public void testPlayHistory() {
        // Play two songs
        player.playNextSong();
        player.playNextSong();

        // Verify history
        List<Song> history = player.getPlayHistory();
        assertEquals(2, history.size());
        assertEquals("Song2", history.get(1).getTitle());
    }

    @Test
    public void testEmptyHistory() {
        // No songs played yet
        assertTrue(player.getPlayHistory().isEmpty());
    }
}
