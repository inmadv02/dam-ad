package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
public class Song implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "artist", foreignKey = @ForeignKey(name = "FK_SONG_ARTIST"))
    private Artist artist;


    //////  HELPERS  /////////

    public void addSong(Artist a) {
        this.artist = a;
        a.getSongs().add(this);
    }

    public void removeSong(Artist a) {
        a.getSongs().remove(this);
        this.artist = null;
    }
}
