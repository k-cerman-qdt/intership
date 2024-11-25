package org.kure.example4.storage;

import org.kure.example4.Song;

import java.util.List;

public interface MusicStorage {
    List<Song> loadSongs();
    void saveSongs(List<Song> songs);
}
