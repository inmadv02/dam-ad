package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    @OneToMany(mappedBy = "song")
    private List<AddedTo> aniadidas = new ArrayList<>();

    //////  HELPERS  /////////

    public void addArtist(Artist a) {
        this.artist = a;

        if(a.getSongs() == null){
            a.setSongs(new ArrayList<>());
            a.getSongs().add(this);
        }

    }

    public void removeArtis(Artist a) {
        a.getSongs().remove(this);
        this.artist = null;
    }
}
