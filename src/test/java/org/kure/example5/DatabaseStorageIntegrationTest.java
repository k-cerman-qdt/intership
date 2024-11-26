package org.kure.example5;

import org.junit.jupiter.api.Test;
import org.kure.example5.database.DbConnection;
import org.kure.example5.storage.DatabaseStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class DatabaseStorageIntegrationTest {


    @Test
    void realConnectionTest() throws SQLException {

        DbConnection dbConnection = getDdConnection();
        Connection connection = null;

        try {
            connection = dbConnection.createConnection();
            DatabaseStorage storage = new DatabaseStorage(connection);

            storage.loadSongs();


            storage.saveSongs(List.of());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            Objects.requireNonNull(connection).close();
        }
    }

    private static DbConnection getDdConnection() {
        return new DbConnection("jdbc:mysql://localhost:3306/example5", "root", "");
    }


    private void fillData(){

    }
}
