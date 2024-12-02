package org.kure.example4;

public interface Song {
    String getTitle();
    String getArtist();
    int getDuration();
    void setArtist(String artist);
    void setTitle(String title);
    void setDuration(int duration);
}
