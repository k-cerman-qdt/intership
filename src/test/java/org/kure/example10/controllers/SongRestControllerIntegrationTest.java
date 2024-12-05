package org.kure.example10.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.kure.example10.database.SongRepository;
import org.kure.example10.database.entities.Song10;
import org.kure.example4.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SongRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test create and get song")
    void testCreateAndGetSong() throws Exception {
        // Create a new song
        Song10 song = new Song10("Integration Song", "Integration Artist", 400);

        mockMvc.perform(post("/songs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(song)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Integration Song"));

        // Retrieve the song
        mockMvc.perform(get("/songs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Integration Song"));
    }

    @Test
    @DisplayName("Test getSongById")
    void testGetSongByIdNotFound() throws Exception {
        mockMvc.perform(get("/songs/1000"))
                .andExpect(status().isNotFound());
    }
}
