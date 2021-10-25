package com.salesianostriana.dam.E07_InmaculadaDominguezVargas;

import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.model.*;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.repositorios.SongRepository;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.AddedToService;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.ArtistService;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.PlaylistService;
import com.salesianostriana.dam.E07_InmaculadaDominguezVargas.servicios.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final ArtistService artistService;
    private final PlaylistService playlistService;
    private final SongService songService;
    private final AddedToService addedToService;

    @PostConstruct
    public void init(){

        Artist artist = Artist.builder().name("Taylor Swift").build();

        artistService.save(artist);

        List<Song> canciones = List.of(Song.builder().title("Blank Space").build(),
                                Song.builder().title("Bad Blood").build(),
                                Song.builder().title("Wildest Dreams").build());

        for(int i = 0; i < canciones.size(); i++){
           canciones.get(i).addArtist(artist);
        }

        songService.saveAll(canciones);

        Song song = Song.builder().title("1984").build();

        artist.setSongs(canciones);

        songService.save(song);

        Playlist playlist = Playlist.builder().name("Taylor's Songs").description("Canciones de Taylor Swift").build();

        playlistService.save(playlist);

        AddedToPK addedToPk = new AddedToPK(playlist.getId(), song.getId());

        AddedTo addedTo = AddedTo.builder().id(addedToPk).dateTime(LocalDateTime.now()).build();

        addedToService.save(addedTo);

        for(int i = 0; i < canciones.size(); i++){
            addedTo.addSong(canciones.get(i));
        }

        addedTo.addPlaylist(playlist);


    }
}
