package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class E01_PracticaGuida_MInmaculadaDominguezVargasApplication {

    public static void main(String[] args) {
        SpringApplication.run(E01_PracticaGuida_MInmaculadaDominguezVargasApplication.class, args);
    }

}
