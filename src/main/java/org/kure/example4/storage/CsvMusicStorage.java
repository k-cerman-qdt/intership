package org.kure.example4.storage;

import org.kure.example4.entities.SongImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvMusicStorage implements MusicStorage<SongImpl> {
    private String filePath;

    public CsvMusicStorage(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<SongImpl> loadSongs() {
        List<SongImpl> songs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0];
                String artist = parts[1];
                int duration = Integer.parseInt(parts[2]);
                songs.add(new SongImpl(title, artist, duration));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }

    @Override
    public void saveSongs(List<SongImpl> songs) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (SongImpl song : songs) {
                bw.write(song.getTitle() + "," + song.getArtist() + "," + song.getDuration());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
