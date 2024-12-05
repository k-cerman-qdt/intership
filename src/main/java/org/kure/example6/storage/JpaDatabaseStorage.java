package org.kure.example6.storage;

import org.kure.example4.Song;
import org.kure.example4.storage.MusicStorage;
import org.kure.example6.database.SongRepository;
import org.kure.example6.storage.entities.SongJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Simple implementation of the {@link MusicStorage} interface that uses a JPA database to store songs.
 */
@Service
public class JpaDatabaseStorage implements MusicStorage<Song> {

    private final SongRepository songRepository;

    @Autowired
    public JpaDatabaseStorage(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> loadSongs() {
        return List.copyOf(songRepository.findAll());
    }

    @Override
    public void saveSongs(List<Song> songs) {
        songRepository.saveAll(songs.stream().map(SongJpa::new).toList());
    }
}
