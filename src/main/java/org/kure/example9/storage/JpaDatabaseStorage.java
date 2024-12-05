package org.kure.example9.storage;

import org.kure.example4.storage.MusicStorage;
import org.kure.example9.database.SongRepository;
import org.kure.example9.storage.entities.SongJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaDatabaseStorage implements MusicStorage<SongJpa> {

    private final SongRepository songRepository;

    @Autowired
    public JpaDatabaseStorage(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<SongJpa> loadSongs() {
        return songRepository.findAllCustom();
    }

    @Override
    public void saveSongs(List<SongJpa> songs) {
        songRepository.saveAllCustom(songs);
    }
}