package org.kure.example4.listener;

import org.kure.example4.Song;

public class ConsoleMusicPlayerEventListener implements MusicPlayerEventListener {
    @Override
    public void onSongStarted(Song song) {
        System.out.println("🎵 Event: Song started - " + song);
    }

    @Override
    public void onPlaylistEmpty() {
        System.out.println("⚠️ Event: Playlist is empty. Add more songs!");
    }
}
