package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.controller;


import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.CreateEstacionDTO;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.EstacionDTOConverter;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.GetEstacionDTO;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.model.Estacion;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionController {


    private final EstacionService estacionService;
    private final EstacionDTOConverter converter;


    @GetMapping("/")
    public ResponseEntity<List<GetEstacionDTO>> findAll(){
        List<GetEstacionDTO> lista = estacionService
                .todasLasEstaciones()
                .stream()
                .map(converter::estacionToEstacionDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(lista);

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetEstacionDTO> findOne(@PathVariable Long id) {

        Estacion estacion = estacionService.unaEstacion(id);

        return ResponseEntity.ok().body(converter.estacionToEstacionDTO(estacion));
    }


    @PostMapping("/")
    public ResponseEntity<CreateEstacionDTO> addEstacion(@Valid @RequestBody CreateEstacionDTO createEstacionDTO){

        estacionService.nuevaEstacion(createEstacionDTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(createEstacionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetEstacionDTO> editEstacion(@Valid @RequestBody GetEstacionDTO dto,
                                                          @PathVariable Long id){

        Estacion estacion = estacionService.unaEstacion(id);
        GetEstacionDTO getEstacionDTO = converter.estacionToEstacionDTO(estacion);

        estacionService.editEstacion(getEstacionDTO, id);

        return ResponseEntity.ok().body(getEstacionDTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstacion(@PathVariable Long id){

        estacionService.borrarEstacion(id);

        return ResponseEntity.noContent().build();
    }









}
