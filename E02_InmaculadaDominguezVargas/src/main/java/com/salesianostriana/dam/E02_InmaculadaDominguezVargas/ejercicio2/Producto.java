package com.salesianostriana.dam.E02_InmaculadaDominguezVargas.ejercicio2;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@Table(name = "product")
public class Producto implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    //@Lob
    @Column(name = "name", length = 255, nullable = false)
    private String nombre;

    @Column(name = "price", nullable = false)
    private float precio;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "description")
    private String descripcion;
}
