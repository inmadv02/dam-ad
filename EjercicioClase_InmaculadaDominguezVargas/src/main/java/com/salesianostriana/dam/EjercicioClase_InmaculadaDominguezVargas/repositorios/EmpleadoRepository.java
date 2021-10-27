package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.repositorios;

import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
