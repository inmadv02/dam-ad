package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.repositorios;

import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.Playlist;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
