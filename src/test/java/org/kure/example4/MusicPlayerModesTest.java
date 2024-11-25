package org.kure.example4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kure.example4.storage.MusicStorage;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MusicPlayerModesTest {
    private MusicPlayer player;

    @BeforeEach
    public void setup() {
        MusicStorage mockStorage = mock(MusicStorage.class);
        when(mockStorage.loadSongs()).thenReturn(
                List.of(
                        new Song("Song1", "Artist1", 1),
                        new Song("Song2", "Artist2", 2),
                        new Song("Song3", "Artist3", 3)
                )
        );

        player = new MusicPlayer(mockStorage);
    }

    @Test
    public void testShuffleMode() {
        player.setShuffleMode(true);

        // Play songs in shuffle mode
        player.playNextSong();
        player.playNextSong();
        player.playNextSong();

        // All songs should be played but in random order
        assertEquals(3, player.getPlayHistory().size());
        assertTrue(player.getPlayHistory().stream()
                .anyMatch(song -> song.getTitle().equals("Song1")));
    }

    @Test
    public void testRepeatMode() {
        player.setRepeatMode(true);

        // Play the first song
        player.playNextSong();
        Song firstSong = player.getPlayHistory().get(0);

        // Play again in repeat mode
        player.playNextSong();
        Song repeatedSong = player.getPlayHistory().get(1);

        // The song should be repeated
        assertEquals(firstSong, repeatedSong);
        assertEquals(2, player.getPlayHistory().size());
    }
}
