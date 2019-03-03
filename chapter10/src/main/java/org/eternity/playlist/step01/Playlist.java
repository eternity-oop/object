package org.eternity.playlist.step01;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> tracks = new ArrayList<>();

    public void append(Song song) {
        getTracks().add(song);
    }

    public List<Song> getTracks() {
        return tracks;
    }
}
