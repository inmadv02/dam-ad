package com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.repositorios;

import com.salesianostriana.dam.EjercicioClase_InmaculadaDominguezVargas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
