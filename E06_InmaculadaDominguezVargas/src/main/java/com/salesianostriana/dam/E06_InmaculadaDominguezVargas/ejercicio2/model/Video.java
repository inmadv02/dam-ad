package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion, titulo, url;
    private int orden;

    @ManyToOne
    @JoinColumn(name = "videos", foreignKey = @ForeignKey(name = "FK_CURSOONLINE_VIDEO"))
    private CursoOnline cursoOnline;

    public void addCurso (CursoOnline c){
        this.cursoOnline = c;
        c.getVideos().add(this);
    }

    public void removeCurso (CursoOnline c){
        c.getVideos().remove(this);
        this.cursoOnline = null;
    }
}
