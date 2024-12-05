package org.kure.example9.listener;

import org.kure.example4.Song;
import org.kure.example4.listener.MusicPlayerEventListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingEventListener implements MusicPlayerEventListener {
    private static final Logger logger = LogManager.getLogger(LoggingEventListener.class);

    @Override
    public void onSongStarted(Song song) {
        logger.info("Starting song: {}", song);
    }

    @Override
    public void onPlaylistEmpty() {
        logger.warn("Playlist is empty. Add more songs!");
    }
}
