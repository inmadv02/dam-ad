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
public class Playlist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
    private List<AddedTo> aniadidas = new ArrayList<>();
}
