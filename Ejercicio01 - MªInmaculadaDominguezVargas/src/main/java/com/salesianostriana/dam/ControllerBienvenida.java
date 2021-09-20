package com.salesianostriana.dam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ControllerBienvenida {

    private static final String mensaje = "Hola, %s";
    private final AtomicLong contador = new AtomicLong();

    @GetMapping("/bienvenida")
    public Bienvenida greeting(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre) {
        return new Bienvenida(contador.incrementAndGet(), String.format(mensaje, nombre));
    }


}
