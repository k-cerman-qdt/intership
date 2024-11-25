package org.kure.example4.listener;

import org.kure.example4.Song;

public interface MusicPlayerEventListener {
    void onSongStarted(Song song);
    void onPlaylistEmpty();
}
