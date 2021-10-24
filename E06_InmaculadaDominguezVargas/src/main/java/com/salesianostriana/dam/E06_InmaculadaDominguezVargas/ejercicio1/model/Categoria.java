package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Builder.Default
    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Producto> productos = new ArrayList<>();

    private int categoria_padre; //He probado primero haciendo una herencia, pero la
                    // clase subcategoria no debe heredar todos los atrbutos de la clase
                    // madre, como por ejemplo, el atributo List <Subcategoria> que las
                    // relacionaba. Por ello, he optado por poner una variable que indique
                    // quién es la categoría padre de cada una de ellas, como en la base de
                    // datos HR

}
