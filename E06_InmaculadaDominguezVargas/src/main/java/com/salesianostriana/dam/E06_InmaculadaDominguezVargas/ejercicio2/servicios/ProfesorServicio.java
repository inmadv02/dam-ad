package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.servicios;

import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.servicios.base.BaseService;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServicio extends
        BaseService<Profesor, Long, JpaRepository<Profesor, Long>> {
}
