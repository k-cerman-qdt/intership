package org.kure.example4.shuffle;

import org.kure.example4.Song;

public class ShufflerFactory {

    public Shuffler<Song> createRandomizer(ShufflerType type) {
        switch (type) {
            case BACKWARD:
                return new BackwardShuffler();
            case FORWARD:
                return new ForwardShuffler();
            case RANDOM:
                return new RandomShuffler();
            default:
                throw new IllegalArgumentException("Unknown randomizer type: " + type);
        }
    }

}
