package org.kure.example7.storage.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * A JPA entity representing a rock song.
 */
@Entity
@DiscriminatorValue("ROCK")
public class RockSong extends AbstractSong {

    @Id
    @GeneratedValue
    private Long id;

    public RockSong(String title, String artist, int duration) {
        super(title, artist, duration);
    }

    // Required by JPA
    public RockSong() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
