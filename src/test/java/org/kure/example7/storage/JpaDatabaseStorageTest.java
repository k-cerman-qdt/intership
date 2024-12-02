package org.kure.example7.storage;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kure.example4.Song;
import org.kure.example7.TestConfig;
import org.kure.example7.database.SongService;
import org.kure.example7.storage.entities.PopSong;
import org.kure.example7.storage.entities.RockSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@ActiveProfiles("test")
@ContextConfiguration(classes = TestConfig.class)
class JpaDatabaseStorageTest {

    @Autowired
    private SongService songService;

    @Test
    void testSaveAndLoadSongs() {
        JpaDatabaseStorage storage = new JpaDatabaseStorage(songService);
        PopSong popSong = new PopSong();
        popSong.setArtist("Pop Artist");
        popSong.setTitle("Pop Title");
        popSong.setDuration(200);

        RockSong rockSong = new RockSong();
        rockSong.setArtist("Rock Artist");
        rockSong.setTitle("Rock Title");
        rockSong.setDuration(300);

        storage.saveSongs(List.of(popSong, rockSong));

        List<Song> songs = storage.loadSongs();
        assertEquals(2, songs.size(), "There should be 2 songs in the database");
        List<String> titles = songs.stream().map(Song::getTitle).toList();
        Assertions.assertThat(titles.toArray()).contains("Pop Title", "Rock Title");
    }
}