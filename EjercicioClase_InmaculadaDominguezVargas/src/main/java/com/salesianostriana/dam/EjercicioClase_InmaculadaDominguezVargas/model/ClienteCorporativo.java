package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter @Setter
@NoArgsConstructor
public class ClienteCorporativo extends Cliente {

    private double beneficios;
    private double gastos;
    private double num_ventas;

    @ManyToOne
    @JoinColumn(name = "empleado", foreignKey = @ForeignKey(name = "FK_EMPLEADO_CLIENTECORP"))
    private Empleado empleado;

    public ClienteCorporativo(Long id, String nombreCompania, String nombreContacto, String telefono,
                              String direccion, String ciudad, List<Pedido> pedidosList, double beneficios,
                              double gastos, double num_ventas, Empleado empleado) {

        super(id, nombreCompania, nombreContacto, telefono, direccion, ciudad, pedidosList);
        this.beneficios = beneficios;
        this.gastos = gastos;
        this.num_ventas = num_ventas;
        this.empleado = empleado;
    }


    /// MÉTODOS HELPER ///

    public void addToEmpleado (Empleado e){
        this.empleado = e;
        e.getClienteCorporativoList().add(this);
    }

    public void removeFromEmpleado (Empleado e){
        e.getClienteCorporativoList().remove(this);
        this.empleado = null;
    }
}
