package org.kure.example4;

import org.junit.jupiter.api.Test;
import org.kure.example4.entities.SongImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongImplTest {

    @Test
    public void testSongCreation() {
        SongImpl song = new SongImpl("Imagine", "John Lennon", 183);

        assertEquals("Imagine", song.getTitle());
        assertEquals("John Lennon", song.getArtist());
        assertEquals(183, song.getDuration());
    }

    @Test
    public void testSongToString() {
        SongImpl song = new SongImpl("Imagine", "John Lennon", 183);

        assertEquals("Imagine by John Lennon (183s)", song.toString());
    }
}
