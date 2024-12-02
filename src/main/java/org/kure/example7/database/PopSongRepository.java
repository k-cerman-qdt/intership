package org.kure.example7.database;

import org.kure.example7.storage.entities.PopSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopSongRepository extends JpaRepository<PopSong, Long> {
}
