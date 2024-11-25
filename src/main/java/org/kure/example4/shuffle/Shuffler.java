package org.kure.example4.shuffle;

import org.kure.example4.Song;

import java.util.List;

public interface Shuffler {

    Song getSong(List<Song> songList);
}
