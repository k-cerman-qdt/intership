package org.kure.example7.storage.entities;

import jakarta.persistence.*;
import org.kure.example4.Song;

/**
 * An abstract JPA entity representing a song.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "song_type", discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractSong implements Song {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String artist;
    private int duration;

    public AbstractSong(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    // Required by JPA
    public AbstractSong() {
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
