package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.repositorios;

import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
