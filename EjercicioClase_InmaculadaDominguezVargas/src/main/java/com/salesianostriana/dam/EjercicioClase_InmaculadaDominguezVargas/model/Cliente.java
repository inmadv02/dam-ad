package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreCompania;
    private String nombreContacto;
    private String telefono;
    private String direccion;
    private String ciudad;

    @Builder.Default
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidosList = new ArrayList<>();


}
