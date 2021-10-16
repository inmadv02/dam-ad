package com.salesianostriana.dam.E02_InmaculadaDominguezVargas.ejercicio1;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pais")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(length = 128)
    private String nombre;

}
