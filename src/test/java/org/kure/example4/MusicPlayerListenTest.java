package org.kure.example4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kure.example4.entities.SongImpl;
import org.kure.example4.storage.MusicStorage;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class MusicPlayerListenTest {
    private MusicPlayer player;
    private SongImpl s1;

    @BeforeEach
    public void setup() {
        MusicStorage mockStorage = mock(MusicStorage.class);
        s1 = new SongImpl("Song1", "Artist1", 5);
        when(mockStorage.loadSongs()).thenReturn(
                List.of(s1)
        ); // Simulate a 5-second song

        player = new MusicPlayer(mockStorage);
    }

    @Test
    public void testPlaySong() {
        // Spy on the MusicPlayer to monitor calls
        MusicPlayer spyPlayer = Mockito.spy(player);

        // Play a song
        spyPlayer.playNextSong();

        // Verify playback simulation was called
        verify(spyPlayer, times(1)).listen(s1);
    }
}
