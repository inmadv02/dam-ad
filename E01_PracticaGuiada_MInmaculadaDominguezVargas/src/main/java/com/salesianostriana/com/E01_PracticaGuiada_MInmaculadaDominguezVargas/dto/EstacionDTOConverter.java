package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.model.Estacion;
import org.springframework.stereotype.Component;

@Component
public class EstacionDTOConverter {


    public GetEstacionDTO estacionToEstacionDTO(Estacion e){
        return GetEstacionDTO
                .builder()
                .nombre(e.getNombre())
                .marca(e.getMarca())
                .ubicacion(e.getUbicacion())
                .precioGasoilNormal(e.getPrecioGasoilNormal())
                .precioGasoil95Octanos(e.getPrecioGasoil95Octanos())
                .precioGasoilEspecial(e.getPrecioGasoilEspecial())
                .precioGasolina98(e.getPrecioGasolina98())
                .fechaApertura(e.getFechaApertura())
                .build();
    }


    public Estacion createEstacion(CreateEstacionDTO c){
        return new Estacion(
                c.getNombre(),
                c.getMarca(),
                c.getUbicacion(),
                c.getPrecioGasoilNormal(),
                c.getPrecioGasoil95Octanos(),
                c.getPrecioGasoilEspecial(),
                c.getPrecioGasolina98(),
                c.getServicios(),
                c.isTieneAutolavado(),
                c.getFechaApertura()
                );
    }
}
