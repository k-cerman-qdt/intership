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

    /**
     * curl -X POST -H "Content-Type: application/json" -d '{"title": "Song Title", "artist": "Artist Name", "duration": 300}' http://host:port/songs
     * @param song
     * @return
     */
    @PostMapping
    public Song10 createSong(@RequestBody Song10 song) {
        return songRepository.save(song);
    }

    /**
     * curl -X GET http://host:port/songs
     * @return
     */
    @GetMapping
    public List<Song10> getAllSongs() {
        return new ArrayList<>(songRepository.findAll());
    }


    /**
     * curl -X GET http://host:port/songs/1
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Song10> getSongById(@PathVariable("id") Long id) {
        return songRepository.findById(id)
                .map(song -> ResponseEntity.ok().body(song))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * curl -X PUT -H "Content-Type: application/json" -d '{"title": "Updated Title", "artist": "Updated Artist", "duration": 320}' http://host:port/songs/1
     * @param id
     * @param songDetails
     * @return
     */
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

    /**
     * curl -X DELETE http://host:port/songs/1
     * @param id
     * @return
     */
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
