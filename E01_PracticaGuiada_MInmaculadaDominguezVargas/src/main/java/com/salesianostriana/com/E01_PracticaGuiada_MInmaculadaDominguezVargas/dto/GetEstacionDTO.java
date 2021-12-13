package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEstacionDTO {

    @NotNull(message = "{estacion.nombre.null}")
    private String nombre;

    private String marca;

    @NotNull(message = "{estacion.ubicacion.null}")
    private String ubicacion;

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

    @Past(message = "{estacion.fechaApertura.past}")
    private LocalDate fechaApertura;
}
