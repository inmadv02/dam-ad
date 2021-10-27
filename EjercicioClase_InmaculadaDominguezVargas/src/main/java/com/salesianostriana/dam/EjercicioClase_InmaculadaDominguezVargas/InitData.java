package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas;

import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Cliente;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.ClienteCorporativo;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Empleado;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Pedido;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.servicios.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitData {

    private final ClienteServicio clienteServicio;
    private final ClienteCorporativoServicio clienteCorporativoServicio;
    private final ClienteIndividualServicio clienteIndividualServicio;
    private final PedidoServicio pedidoServicio;
    private final EmpleadoServicio empleadoServicio;

    @PostConstruct
    public void init(){

        Cliente cliente = Cliente.builder().nombreCompania("Ayesa")
                .ciudad("Sevilla")
                .direccion("C. Marie Curie, 2")
                .nombreContacto("Ayesa")
                .telefono("954 46 70 46")
                .build();

        clienteServicio.save(cliente);

        Empleado empleado = Empleado.builder()
                .nombre("Inmaculada")
                .apellidos("Domínguez Vargas")
                .email("dominguez.vamar21@triana.salesianos.edu")
                .telefono("143568900")
                .build();

        empleadoServicio.save(empleado);

        Pedido pedido = Pedido.builder()
                .direccion("C/Corral de la Caridad nº13 1ºD")
                .total(56.78)
                .build();

        pedido.addToCliente(cliente);




    }
}
