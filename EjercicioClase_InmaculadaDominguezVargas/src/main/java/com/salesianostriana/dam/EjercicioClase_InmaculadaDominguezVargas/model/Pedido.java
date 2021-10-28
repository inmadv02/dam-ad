package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    private LocalDateTime fecha_pedido;

    @CreatedDate
    private LocalDate fecha_entrega;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    private Long id_empleado;
    private String direccion;
    private double total;

    @ManyToOne
    @JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "FK_CLIENTE_PEDIDO"))
    private Cliente cliente;


    //// MÉTODOS HELPER ///

    public void addToCliente(Cliente c){
        this.cliente = c;
        c.getPedidosList().add(this);
    }

    public void removeFromCliente(Cliente c){
        c.getPedidosList().remove(this);
        this.cliente = null;
    }

}
