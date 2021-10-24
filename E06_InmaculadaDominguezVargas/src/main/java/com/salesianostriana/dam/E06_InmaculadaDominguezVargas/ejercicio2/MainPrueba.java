package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2;

import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.model.CursoOnline;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.model.Profesor;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.model.Video;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.servicios.CursoOnlineServicio;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio2.servicios.ProfesorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MainPrueba {

    private final ProfesorServicio profesorServicio;
    private final CursoOnlineServicio cursoOnlineServicio;

    @PostConstruct
    public void init(){

        Profesor profesor = Profesor.builder().nombre("Luis Miguel López")
                .email("lmlopez@gmail.com")
                .puntuacion(4.5)
                .build();

        profesorServicio.save(profesor);

        List <Video> videos = List.of(Video.builder().orden(1).titulo("Introducción")
                        .descripcion("Vídeo introductorio al curso").build(),
                Video.builder().orden(2).titulo("Lambda")
                        .descripcion("Todo lo que debes saber sobre Lambda").build(),
                Video.builder().orden(3).titulo("Stream")
                        .descripcion("Todo lo que debes saber sobre Stream").build());

        List <CursoOnline> cursos = List.of(CursoOnline.builder().nombre("Spring JPA").puntuacion(4.2).build(),
                                            CursoOnline.builder().nombre("Java 8").puntuacion(4.5).build(),
                                            CursoOnline.builder().nombre("Docker").puntuacion(4.6).build());



        cursos.forEach(c -> c.addProfesor(profesor));
        cursos.forEach(s -> s.setVideos(videos));

        cursoOnlineServicio.saveAll(cursos);

        profesor.getCursosOnline().forEach(p -> {
            System.out.println(p.getNombre() + "  " + p.getProfesor().getNombre() + "  " + p.getPuntuacion());
        });




    }


}
