package org.kure.example9.storage;

import org.junit.jupiter.api.Test;
import org.kure.example4.MusicPlayer;
import org.kure.example4.Song;
import org.kure.example9.TestConfig;
import org.kure.example9.database.SongRepository;
import org.kure.example9.storage.entities.SongJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
@ContextConfiguration(classes = TestConfig.class)
class JpaDatabaseStorageTest {

    @Autowired
    private SongRepository songRepository;

    @Test
    void testSaveAndLoadSongs() {
        JpaDatabaseStorage storage = new JpaDatabaseStorage(songRepository);

        SongJpa song1 = new SongJpa("Song1", "Author1", 180);
        SongJpa song2 = new SongJpa("Song2", "Author2", 200);
        List<SongJpa> savedSongs = Arrays.asList(song1, song2);

        // Save songs to the database
        storage.saveSongs(savedSongs);

        // Fetch all songs from the database
        List<SongJpa> loadedSongs = storage.loadSongs();

        assertThat(loadedSongs).hasSize(2);
        assertThat(loadedSongs).extracting(Song::getTitle).containsOnly("Song1", "Song2");
        assertThat(loadedSongs).extracting(Song::getArtist).containsOnly("Author1", "Author2");
        assertThat(loadedSongs).extracting(Song::getDuration).containsOnly(180, 200);
    }

}