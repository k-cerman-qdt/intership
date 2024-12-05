package org.kure.example10.controllers;


import org.kure.example10.database.SongRepository;
import org.kure.example10.database.entities.Song10;
import org.kure.example4.Song;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongRestController {

    private final SongRepository songRepository;

    public SongRestController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PostMapping
    public Song10 createSong(@RequestBody Song10 song) {
        return songRepository.save(song);
    }

    @GetMapping
    public List<Song10> getAllSongs() {
        return new ArrayList<>(songRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song10> getSongById(@PathVariable("id") Long id) {
        return songRepository.findById(id)
                .map(song -> ResponseEntity.ok().body(song))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song10> updateSong(@PathVariable Long id, @RequestBody Song songDetails) {
        Optional<Song10> songOptional = songRepository.findById(id);

        if (songOptional.isPresent()) {
            Song10 song = songOptional.get();
            song.setTitle(songDetails.getTitle());
            song.setArtist(songDetails.getArtist());
            song.setDuration(songDetails.getDuration());
            Song10 updatedSong = songRepository.save(song);
            return ResponseEntity.ok(updatedSong);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable Long id) {
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
