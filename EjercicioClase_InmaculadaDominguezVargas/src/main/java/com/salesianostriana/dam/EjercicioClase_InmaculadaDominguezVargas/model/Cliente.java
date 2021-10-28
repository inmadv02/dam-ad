package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
            name = Cliente.CLIENTE_PEDIDO,
            attributeNodes = {
                  @NamedAttributeNode("pedidos")
        }
)
@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@SuperBuilder
@DiscriminatorValue("C")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cliente implements Serializable {

    public static final String CLIENTE_PEDIDO = "grafo-cliente-pedido";

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    //Corregir y poner esto

    /*
        private String nombre, apellidos, email;
        private String direccion, poblacion, cp, provincia, telefono;

     */
    protected String nombreCompania;
    protected String nombreContacto;
    protected String telefono;
    protected String direccion;
    protected String ciudad;

    @Builder.Default
    @OneToMany(mappedBy = "cliente")
    protected List<Pedido> pedidosList = new ArrayList<>();


}
