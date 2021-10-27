package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;

import lombok.*;

import javax.persistence.Entity;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter @Setter
@NoArgsConstructor
public class ClienteIndividual extends Cliente{

    private String nombre;
    private String apellidos;

    public ClienteIndividual(Long id, String nombreCompania, String nombreContacto, String telefono, String direccion, String ciudad, List<Pedido> pedidosList, String nombre, String apellidos) {
        super(id, nombreCompania, nombreContacto, telefono, direccion, ciudad, pedidosList);
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
}
