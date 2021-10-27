package com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios;

import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.AddedTo;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.AddedToPK;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.Playlist;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.Song;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.repositorios.AddedToRepository;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.base.BaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddedToService extends BaseService<AddedTo, AddedToPK, AddedToRepository> {

    public void createAddedTo (Playlist p, Song s, SongService songService, PlaylistService playlistService){

        AddedTo addedTo = AddedTo.builder()
                .orden(7)
                .dateTime(LocalDateTime.now())
                .build();

        addedTo.addSongPlaylist(s, p); //Con esto añadimos una canción y una playlist bidireccionalmente
                                        //al AddedTo

        save(addedTo);
        songService.save(s);
        playlistService.save(p);
    }

}
