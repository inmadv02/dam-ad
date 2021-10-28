package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
//@EqualsAndHashCode(callSuper = true)
//@ToString(callSuper = true)
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("CI")
public class ClienteIndividual extends Cliente{


    /*
        private int puntosAcumulados;
     */

    private String nombre;
    private String apellidos;


}
