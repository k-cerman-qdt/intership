package org.kure.example4.storage;

import org.kure.example4.Song;

import java.util.List;

public interface MusicStorage <T extends Song> {
    List<T> loadSongs();
    void saveSongs(List<T> songs);
}
