package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.anotaciones.FechaABeforeFechaR;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones.LocationMatch;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones.UniqueLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@FechaABeforeFechaR.List({
        @FechaABeforeFechaR(
                fechaA = "fechaApertura",
                fechaR = "fechaRegistro",
                message = "{estacion.fechas.invalid}"
        )
})
public class CreateEstacionDTO {

    @NotNull(message = "{estacion.nombre.null}")
    private String nombre;

    private String marca;

    @UniqueLocation(message = "{estacion.location.unique}")
    @LocationMatch(message = "{estacion.location.format}")
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
    private LocalDateTime fechaApertura;

    private LocalDateTime fechaRegistro;
}
