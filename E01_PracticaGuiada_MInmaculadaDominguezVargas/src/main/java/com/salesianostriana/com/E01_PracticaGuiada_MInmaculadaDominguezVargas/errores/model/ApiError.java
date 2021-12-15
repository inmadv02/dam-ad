package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private HttpStatus estado;
    private int codigo;
    private String mensaje;
    private String ruta;

    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime fecha = LocalDateTime.now();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ApiSubError> subErrores;


    public ApiError(HttpStatus estado, String mensaje, String ruta) {
        this.estado = estado;
        this.codigo = estado.value();
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
        this.ruta = ruta;
    }

    public ApiError(String message, HttpStatus notFound) {
        this.mensaje = message;
        this.estado = notFound;
    }

    public ApiError(String message, HttpStatus notFound, LocalDateTime now, String requestURI) {
        this.estado = notFound;
        this.mensaje = message;
        this.ruta = requestURI;
        this.fecha = now;
    }

    public ApiError(HttpStatus notFound, String mensaje, String requestURI, List<ApiSubError> subErrores, LocalDateTime fecha) {
        this.estado = notFound;
        this.mensaje = mensaje;
        this.ruta = requestURI;
        this.subErrores = subErrores;
        this.fecha = fecha;
    }
}
