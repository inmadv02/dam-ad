package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre, email;
    private double puntuacion;

    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER)
    private List<CursoOnline> cursosOnline = new ArrayList<>();
}
