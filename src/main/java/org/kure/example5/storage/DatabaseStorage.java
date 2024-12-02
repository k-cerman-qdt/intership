package org.kure.example5.storage;

import org.kure.example4.Song;
import org.kure.example4.entities.SongImpl;
import org.kure.example4.storage.MusicStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is responsible for storing and loading songs from a database.
 * It uses a JDBC connection to interact with the database.
 * Goal:
 * Create mysql database schema to store songs.
 * Create a connection to the database.
 * Load songs from the database.
 * Save songs to the database.
 * Write unit tests for the DatabaseStorage class. (Use mocks to test the DatabaseStorage class.)
 * Write integration tests for the DatabaseStorage class. (Use a real database to test the DatabaseStorage class.)
 * Based on your database schema, write additional tests to cover all business logic stored in the database.
 *
 */
public class DatabaseStorage implements MusicStorage {

    private final Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Song> loadSongs() {
        // Load songs from database
        String query = "SELECT * FROM songs";
        List<Song> songs = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");
                songs.add(new SongImpl(title, artist,1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Closing connection");
        }
        return songs;
    }

    @Override
    public void saveSongs(List<Song> songs) {
        // Save songs to database

        String insertQuery = "INSERT INTO songs (title, artist) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (Song song : songs) {
                preparedStatement.setString(1, song.getTitle());
                preparedStatement.setString(2, song.getArtist());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            System.out.println("Failed to save songs");
            e.printStackTrace();
        }

    }
}
