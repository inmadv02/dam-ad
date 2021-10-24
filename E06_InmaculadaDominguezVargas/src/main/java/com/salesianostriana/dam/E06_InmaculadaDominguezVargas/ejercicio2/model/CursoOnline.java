package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CursoOnline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private double puntuacion;

    @ManyToOne
    @JoinColumn(name = "videos", foreignKey = @ForeignKey(name = "FK_CURSOONLINE_PROFESOR"))
    private Profesor profesor;

    @OneToMany(mappedBy = "cursoOnline", fetch = FetchType.EAGER)
    private List<Video> videos;

    public void addProfesor (Profesor p){
        this.profesor = p;

        if(p.getCursosOnline() == null){
            p.setCursosOnline(new ArrayList<>());
            p.getCursosOnline().add(this);
        }

    }

    public void removeProfesor (Profesor p){
        p.getCursosOnline().remove(this);
        this.profesor = null;
    }
}
