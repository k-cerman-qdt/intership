package org.kure.example9.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kure.example9.storage.entities.SongJpa;

import java.util.List;

public class SongDaoImpl implements SongDao<SongJpa> {

    private static final Logger logger = LogManager.getLogger(SongDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SongJpa> findAllCustom() {
        logger.info("Fetching all songs from the database");
        List<SongJpa> data = entityManager.createQuery("SELECT s FROM SongJpa s", SongJpa.class).getResultList();
        if (logger.isDebugEnabled()) {
            logger.debug("Found {} songs", data.size());
            logger.debug("Songs: {}", data);
        }
        return data;
    }

    @Override
    @Transactional
    public void saveAllCustom(List<SongJpa> songs) {
        logger.info("Saving songs to the database");

        for (SongJpa song : songs) {
            if (entityManager.contains(song)) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Updating song: {}", song);
                }
                entityManager.persist(song);
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug("Inserting song: {}", song);
                }
                entityManager.merge(song);
            }
        }
    }
}
