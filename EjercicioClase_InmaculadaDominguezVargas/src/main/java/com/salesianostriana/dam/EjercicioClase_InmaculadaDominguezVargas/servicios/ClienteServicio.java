package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.servicios;

import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Cliente;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.repositorios.ClienteRepository;
import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.servicios.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio extends BaseService<Cliente, Long, ClienteRepository> {
}
