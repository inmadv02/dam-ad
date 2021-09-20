package com.salesianostriana.dam;

import org.springframework.context.annotation.Primary;

@Primary
public class Bienvenida {

    private final long id;
    private final String contenido;

    public Bienvenida(long id, String contenido) {
        this.id = id;
        this.contenido = contenido;
    }

    public long getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }
}
