package org.kure.example7.storage.entities;

import jakarta.persistence.*;

/**
 * A JPA entity representing a pop song.
 * Customized to use a sequence generator.
 */
@Entity
@DiscriminatorValue("POP")
public class PopSong extends AbstractSong {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "song_sequence")
    @SequenceGenerator(sequenceName = "song_sequence", name = "song_sequence", allocationSize = 1)
    private Long id;

    public PopSong(String title, String artist, int duration) {
        super(title, artist, duration);
    }

    // Required by JPA
    public PopSong() {
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