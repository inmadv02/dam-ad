package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CreateEstacionDTO {

    private String nombre;
    private String marca;
    private String ubicacion;
    private boolean tieneAutolavado;

    private float precioGasoilNormal;
    private float precioGasoil95Octanos;
    private float precioGasoilEspecial;
    private float precioGasolina98;

    private String servicios;

    private LocalDate fechaApertura;
}
