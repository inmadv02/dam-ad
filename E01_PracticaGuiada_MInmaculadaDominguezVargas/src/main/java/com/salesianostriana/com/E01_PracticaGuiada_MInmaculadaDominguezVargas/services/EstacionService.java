package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.services;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.CreateEstacionDTO;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.EstacionDTOConverter;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.GetEstacionDTO;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores.EntityNotFoundException;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores.ListEntityNotFoundException;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.model.Estacion;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.repositories.EstacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionService {


    private final EstacionRepository repository;
    private final EstacionDTOConverter converter;

    public List<Estacion> todasLasEstaciones() throws ListEntityNotFoundException{

        List<Estacion> datos = repository.findAll();

        if (datos.isEmpty()){
            throw new ListEntityNotFoundException(Estacion.class);
        }

        else {
            return datos;
        }

    }


    public Estacion unaEstacion(Long id) throws EntityNotFoundException {

        Optional <Estacion> estacion = repository.findById(id);

        if(estacion.isEmpty()){
            throw new EntityNotFoundException(id, Estacion.class);
        }

        else {
            return estacion.get();
        }

    }


    public Estacion nuevaEstacion(CreateEstacionDTO c){

        Estacion estacion = converter.createEstacion(c);

        this.repository.save(estacion);

        return estacion;
    }

    public Estacion editEstacion(GetEstacionDTO dto, Long id){

        Optional <Estacion> estacion = repository.findById(id);

        if(estacion.isEmpty()){
            throw new EntityNotFoundException(id, Estacion.class);
        }

        else {

           return estacion.map( m -> {
                       m.setNombre(dto.getNombre());
                       m.setMarca(dto.getMarca());
                       m.setUbicacion(dto.getUbicacion());
                       m.setPrecioGasoil95Octanos(dto.getPrecioGasoil95Octanos());
                       m.setPrecioGasoilNormal(dto.getPrecioGasoilNormal());
                       m.setPrecioGasoilEspecial(dto.getPrecioGasoilEspecial());
                       m.setPrecioGasolina98(dto.getPrecioGasolina98());
                       m.setFechaApertura(dto.getFechaApertura());

                       repository.save(estacion.get());
                       return m;
                   }).get();

        }

    }


    public void borrarEstacion(Long id){

        Optional <Estacion> estacion = repository.findById(id);

        if(estacion.isEmpty()){
            throw new EntityNotFoundException(id, Estacion.class);
        }

        else {
            this.repository.delete(estacion.get());

        }

    }




}
