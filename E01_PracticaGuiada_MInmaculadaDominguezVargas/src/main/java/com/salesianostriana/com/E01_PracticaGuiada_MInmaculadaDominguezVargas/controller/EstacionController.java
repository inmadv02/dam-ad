package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.controller;


import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.dto.EstacionDTOConverter;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.services.EstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionController {


    private final EstacionService estacionService;
    private final EstacionDTOConverter converter;





}
