package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CreateEstacionDTO {

    @NotNull(message = "{estacion.nombre.null}")
    private String nombre;

    private String marca;

    @NotNull(message = "{estacion.ubicacion.null}")
    private String ubicacion;

    private boolean tieneAutolavado;

    @NotNull(message = "{estacion.precio.blank}")
    @Min(value = 0, message = "{estacion.precio.min}")
    private double precioGasoilNormal;

    @NotNull(message = "{estacion.precio.blank}")
    @Min(value = 0, message = "{estacion.precio.min}")
    private double precioGasoil95Octanos;

    @Min(value = 0, message = "{estacion.precio.min}")
    private double precioGasoilEspecial;

    @Min(value = 0, message = "{estacion.precio.min}")
    private double precioGasolina98;

    private String servicios;

    @Past(message = "{estacion.fechaApertura.past}")
    private LocalDate fechaApertura;
}
