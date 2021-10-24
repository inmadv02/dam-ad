package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.repositorios;

import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
