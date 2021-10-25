package com.salesianostriana.dam.E02_InmaculadaDominguezVargas.ejercicio1;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
@Table(name = "country")
public class Pais implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    //@Lob
    @Column(name = "name", nullable = false, length = 128)
    private String nombre;

}
