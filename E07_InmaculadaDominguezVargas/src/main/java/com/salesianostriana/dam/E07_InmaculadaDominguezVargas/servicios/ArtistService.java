package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios;

import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.Artist;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.repositorios.ArtistRepository;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.base.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ArtistService extends BaseService<Artist, Long, ArtistRepository> {
}
