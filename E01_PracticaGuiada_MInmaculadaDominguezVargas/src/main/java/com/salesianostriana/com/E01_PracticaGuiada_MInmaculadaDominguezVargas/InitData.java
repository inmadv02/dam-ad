package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.controller.EstacionController;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.model.Estacion;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.repositories.EstacionRepository;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitData {

    private final EstacionController estacionController;
    private final EstacionRepository estacionRepository;

    @PostConstruct
    public void init() {

        Estacion estacion = Estacion
                            .builder()
                            .nombre("Cepsa")
                            .marca("CEPSA")
                            .fechaApertura(LocalDateTime.of(2020, 05,25, 17, 25, 30))
                            .ubicacion("37.549349292902, -05.5392929291")
                            .precioGasoilNormal(1.54)
                            .precioGasoil95Octanos(1.8)
                            .build();

        estacionRepository.save(estacion);

    }
}
