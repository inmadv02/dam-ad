package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private double pvp;

    @ManyToOne
    @JoinColumn(name = "categoria", foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA"))
    private Categoria categoria;

    ///// HELPERS /////

    public void addCategoria(Categoria c){
        this.categoria = c;
        c.getProductos().add(this); //Una vez le asignamos la categoría al producto,
                                    // añadimos este producto en la lista que tenemos en la clase Categoria
    }

    public void removeCategoria(Categoria c){
        c.getProductos().remove(this);
        this.categoria = null;
    }
}
