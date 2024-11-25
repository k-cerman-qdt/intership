package org.kure.example4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    public void testSongCreation() {
        Song song = new Song("Imagine", "John Lennon", 183);

        assertEquals("Imagine", song.getTitle());
        assertEquals("John Lennon", song.getArtist());
        assertEquals(183, song.getDuration());
    }

    @Test
    public void testSongToString() {
        Song song = new Song("Imagine", "John Lennon", 183);

        assertEquals("Imagine by John Lennon (183s)", song.toString());
    }
}
