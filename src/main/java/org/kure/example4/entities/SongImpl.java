package org.kure.example4.entities;

import org.kure.example4.Song;

public class SongImpl implements Song {

    private String title;
    private String artist;
    private int duration;

    public SongImpl(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + duration + "s)";
    }
}