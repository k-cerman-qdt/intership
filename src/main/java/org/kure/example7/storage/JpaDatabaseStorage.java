package org.kure.example7.storage;

import org.kure.example4.Song;
import org.kure.example4.storage.MusicStorage;
import org.kure.example7.database.SongService;

import java.util.List;

/**
 * Simple implementation of the {@link MusicStorage} interface that uses a JPA database to store songs.
 */
public class JpaDatabaseStorage implements MusicStorage<Song> {

    private final SongService songService;

    public JpaDatabaseStorage(SongService songService) {
        this.songService = songService;
    }

    @Override
    public List<Song> loadSongs() {
        return List.copyOf(songService.loadSongs());
    }

    @Override
    public void saveSongs(List<Song> songs) {
        //error handling is missing
        songService.saveAll(songs);
    }
}
