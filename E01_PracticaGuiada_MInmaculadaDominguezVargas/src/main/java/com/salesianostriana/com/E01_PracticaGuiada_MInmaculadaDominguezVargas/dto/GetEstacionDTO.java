package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEstacionDTO {

    @NotNull
    private String nombre;

    private String marca;

    @NotNull
    private String ubicacion;

    @NotEmpty(message = "{estacion.precio.empty")
    @Min(value = 0, message = "{estacion.precio.min")
    private float precioGasoilNormal;

    @NotEmpty(message = "{estacion.precio.empty")
    @Min(value = 0, message = "{estacion.precio.min")
    private float precioGasoil95Octanos;

    @Min(value = 0, message = "{estacion.precio.min")
    private float precioGasoilEspecial;

    @Min(value = 0, message = "{estacion.precio.min")
    private float precioGasolina98;

    @Past
    private LocalDate fechaApertura;
}
