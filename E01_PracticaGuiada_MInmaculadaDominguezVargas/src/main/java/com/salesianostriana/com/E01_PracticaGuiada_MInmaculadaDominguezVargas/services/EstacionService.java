package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.services;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.CreateEstacionDTO;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.EstacionDTOConverter;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.model.Estacion;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.repositories.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {


    private final EstacionRepository repository;
    private final EstacionDTOConverter converter;

    public List<Estacion> todasLasEstaciones() {

        List<Estacion> datos = repository.findAll();

        return datos;
    }


    public Estacion unaEstacion(Long id) {

        return this.repository.findById(id).get();

    }


    public Estacion nueveEstacion(CreateEstacionDTO c){

        Estacion estacion = converter.createEstacion(c);

        this.repository.save(estacion);

        return estacion;
    }


    public void borrarEstacion(Long id){

        this.repository.deleteById(id);

    }




}
