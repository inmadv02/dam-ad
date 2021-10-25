package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios;

import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.Song;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.repositorios.SongRepository;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class SongService extends BaseService<Song, Long, SongRepository> {
}
