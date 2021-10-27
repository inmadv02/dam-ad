package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;

    @CreatedDate
    private LocalDate fecha_entrada;

    @OneToMany(mappedBy = "empleado")
    private List<ClienteCorporativo> clienteCorporativoList = new ArrayList<>();


}
