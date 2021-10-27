package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fecha_pedido;
    private LocalDate fecha_entrega;

    private Cliente cliente;

}
