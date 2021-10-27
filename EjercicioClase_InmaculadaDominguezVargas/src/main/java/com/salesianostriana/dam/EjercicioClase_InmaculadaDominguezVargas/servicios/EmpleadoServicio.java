package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.servicios;

import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Empleado;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Pedido;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.repositorios.EmpleadoRepository;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.repositorios.PedidoRepository;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.servicios.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServicio  extends BaseService<Empleado, Long, EmpleadoRepository> {
}
