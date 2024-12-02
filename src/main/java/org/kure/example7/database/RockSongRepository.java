package org.kure.example7.database;

import org.kure.example7.storage.entities.RockSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RockSongRepository extends JpaRepository<RockSong, Long> {
}
