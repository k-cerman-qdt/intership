package org.kure.example4.shuffle;

import org.kure.example4.Song;

import java.util.List;

public class ForwardShuffler implements Shuffler {
    @Override
    public Song getSong(List<Song> songList) {
        return songList.getFirst();
    }
}
