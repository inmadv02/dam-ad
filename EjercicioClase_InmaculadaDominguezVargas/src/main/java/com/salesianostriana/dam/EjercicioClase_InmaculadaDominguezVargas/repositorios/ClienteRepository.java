package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.repositorios;

import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c where TYPE(c) != ClienteCorporativo and TYPE(c) != ClienteIndividual")
    public List<Cliente> clientesNormales();

}
