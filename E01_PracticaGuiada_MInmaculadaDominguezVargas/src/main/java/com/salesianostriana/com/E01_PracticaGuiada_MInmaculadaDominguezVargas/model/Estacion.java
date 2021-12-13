package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
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

    private float precioGasoilNormal;
    private float precioGasoil95Octanos;
    private float precioGasoilEspecial;
    private float precioGasolina98;

    private String servicios;

    private LocalDate fechaApertura;


    public Estacion(String nombre, String marca, String ubicacion, float precioGasoilNormal, float precioGasoil95Octanos, float precioGasoilEspecial, float precioGasolina98, String servicios, boolean tieneAutolavado, LocalDate fechaApertura) {
    }
}
