package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Estacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String marca;
    private String ubicacion;
    private boolean tieneAutolavado;

    private double precioGasoilNormal;
    private double precioGasoil95Octanos;
    private double precioGasoilEspecial;
    private double precioGasolina98;

    private String servicios;

    private LocalDateTime fechaApertura;

    @CreatedDate
    private LocalDateTime fechaRegistro;


    public Estacion(String nombre, String marca, String ubicacion, double precioGasoilNormal,
                    double precioGasoil95Octanos, double precioGasoilEspecial, double precioGasolina98,
                    String servicios, boolean tieneAutolavado, LocalDateTime fechaApertura) {

        this.nombre = nombre;
        this.marca = marca;
        this.ubicacion = ubicacion;
        this.precioGasoilNormal = precioGasoilNormal;
        this.precioGasoil95Octanos = precioGasoil95Octanos;
        this.precioGasoilEspecial = precioGasoilEspecial;
        this.precioGasolina98 = precioGasolina98;
        this.servicios = servicios;
        this.tieneAutolavado = tieneAutolavado;
        this.fechaApertura = fechaApertura;
    }
}
