package org.kure.example6.database;

import org.kure.example6.storage.entities.SongJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A repository for songs.
 * Additionally, the repository provides a method to check if a song with a given title and artist exists.
 * all possible query method details can be found <a href="https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html">here</a>
 */
@Repository
public interface SongRepository extends JpaRepository<SongJpa, Long> {

    boolean existsByTitleAndArtist(String title, String artist);

}
