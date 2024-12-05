package org.kure.example9.database;

import org.kure.example9.storage.entities.SongJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<SongJpa, Long>, SongDao<SongJpa> {

}
