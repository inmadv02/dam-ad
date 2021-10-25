package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios;

import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.Playlist;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.repositorios.PlaylistRepository;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService extends BaseService<Playlist, Long, PlaylistRepository> {
}
