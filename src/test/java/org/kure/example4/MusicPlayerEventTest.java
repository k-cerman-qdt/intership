package org.kure.example4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kure.example4.entities.SongImpl;
import org.kure.example4.listener.MusicPlayerEventListener;
import org.kure.example4.storage.MusicStorage;

import java.util.List;

import static org.mockito.Mockito.*;

public class MusicPlayerEventTest {
    private MusicPlayerEventListener mockListener;
    private MusicPlayer player;

    @BeforeEach
    public void setup() {
        MusicStorage mockStorage = mock(MusicStorage.class);
        mockListener = mock(MusicPlayerEventListener.class);

        when(mockStorage.loadSongs()).thenReturn(
                List.of(new SongImpl("Imagine", "John Lennon", 1))
        );

        player = new MusicPlayer(mockStorage);
        player.setEventListener(mockListener);
    }

    @Test
    public void testOnSongStartedEvent() {
        player.playNextSong();

        // Verify that the onSongStarted event was triggered
        verify(mockListener, times(1)).onSongStarted(any(SongImpl.class));
    }

    @Test
    public void testOnPlaylistEmptyEvent() {
        player.playNextSong(); // Play the only song
        player.playNextSong(); // Playlist should now be empty

        // Verify that the onPlaylistEmpty event was triggered
        verify(mockListener, times(1)).onPlaylistEmpty();
    }
}
