package org.kure.example7.database;

import org.kure.example4.Song;
import org.kure.example7.storage.entities.PopSong;
import org.kure.example7.storage.entities.RockSong;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * In JPA, you cannot create a repository for an interface directly.
 * You should create a repository for the concrete class (implementation of the interface) instead.
 * This is because JPA works with concrete classes (annotated with @Entity), not interfaces.
 */
@Service
public class SongService {

    private final PopSongRepository popSongRepository;
    private final RockSongRepository rockSongRepository;

    public SongService(PopSongRepository popSongRepository, RockSongRepository rockSongRepository) {
        this.popSongRepository = popSongRepository;
        this.rockSongRepository = rockSongRepository;
    }

    public List<Song> loadSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        songs.addAll(rockSongRepository.findAll());
        songs.addAll(popSongRepository.findAll());
        return songs;
    }

    public void saveAll(List<Song> songs) {
        for (Song song : songs) {
            if (song instanceof PopSong) {
                popSongRepository.save((PopSong) song);
            } else if (song instanceof RockSong) {
                rockSongRepository.save((RockSong) song);
            } else {
                throw new IllegalArgumentException("Unknown song type: " + song.getClass());
            }
        }
    }
}
