package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class AddedTo {

    @Builder.Default
    @EmbeddedId
    private AddedToPK id = new AddedToPK();

    @ManyToOne
    @MapsId("song_id")
    @JoinColumn(name="song_id")
    private Song song;

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name="playlist_id")
    private Playlist playlist;

    private LocalDateTime dateTime;

    private int orden;

    //// HELPERS ////

    public void addSong (Song s){
        this.song = s;
        s.getAniadidas().add(this);

    }

    public void removeSong (Song s){
        s.getAniadidas().remove(this);
        this.song = null;
    }

    public void addPlaylist (Playlist p){
        this.playlist = p;
        p.getAniadidas().add(this);
    }

    public void removePlaylist (Playlist p){
        p.getAniadidas().remove(this);
        this.playlist = null;
    }

    public void addSongPlaylist(Song s, Playlist p) {
        addSong(s);
        addPlaylist(p);
    }

    public void removeSongPlaylist(Song s, Playlist p) {
        removeSong(s);
        removePlaylist(p);
    }





}
