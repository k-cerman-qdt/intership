package org.dominik.gameoflife.model;

public class WorldFactory {

    public World createWorld(int width, int height) {
        return new WorldImpl(width, height);
    }
}
