package org.kure.example10.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kure.example10.database.SongRepository;
import org.kure.example10.database.entities.Song10;
import org.kure.example4.Song;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SongRestControllerTest {

    private SongRepository songRepository;
    private SongRestController songRestController;

    @BeforeEach
    void setUp() {
        songRepository = mock(SongRepository.class);
        songRestController = new SongRestController(songRepository);
    }

    @Test
    @DisplayName("Test getSongById when song exists")
    void testGetSongByIdSongExists() {
        // given
        Song10 song = new Song10("Test Title", "Test Artist", 300);
        song.setId(1L);
        when(songRepository.findById(1L)).thenReturn(Optional.of(song));

        // when
        ResponseEntity<Song10> response = songRestController.getSongById(1L);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(song, response.getBody());
    }

    @Test
    @DisplayName("Test getSongById when song does not exist")
    void testGetSongByIdSongDoesNotExist() {
        // Arrange
        when(songRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Song10> response = songRestController.getSongById(1L);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("Test createSong")
    void testCreateSong() {
        // Arrange
        Song10 song = new Song10("New Song", "New Artist", 320);
        when(songRepository.save(Mockito.any(Song10.class))).thenReturn(song);

        // Act
        Song10 createdSong = songRestController.createSong(song);

        // Assert
        assertEquals("New Song", createdSong.getTitle());
        verify(songRepository, times(1)).save(song);
    }
}