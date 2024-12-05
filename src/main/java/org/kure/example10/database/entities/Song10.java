package org.kure.example10.database.entities;

import jakarta.persistence.*;
import org.kure.example4.Song;

@Entity
@Table(name = "songs")
public class Song10 implements org.kure.example4.Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private int duration;

    public Song10(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    //JPA requires a no-arg constructor
    public Song10() {
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

    @Override
    public String toString() {
        return "Song10{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", duration=" + duration +
                '}';
    }
}
