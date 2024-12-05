package org.kure.example10.database;

import org.kure.example10.database.entities.Song10;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song10, Long> {
}
