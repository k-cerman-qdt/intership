package org.kure.example4.shuffle;

import org.kure.example4.Song;

import java.util.List;
import java.util.Random;

public class RandomShuffler implements Shuffler {
    @Override
    public Song getSong(List<Song> songList) {
        return songList.get(new Random().nextInt(songList.size()));
    }
}
