package com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1;

import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.model.Categoria;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.model.Producto;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.servicios.CategoriaService;
import com.salesianostriana.dam.E06_InmaculadaDominguezVargas.ejercicio1.servicios.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @PostConstruct
    public void test() {

        Categoria categoria = Categoria.builder().nombre("Lácteos").build();

        List<Producto> productos = List.of(Producto.builder().nombre("Leche").pvp(1).build(),
                                    Producto.builder().nombre("Actimel").pvp(1.5).build(),
                                    Producto.builder().nombre("Leche de soja").pvp(1).build(),
                                    Producto.builder().nombre("Yogur natural azucarado").pvp(2.5).build());

        categoriaService.save(categoria);

        productos.forEach(producto -> producto.addCategoria(categoria));

        productoService.saveAll(productos);

        //productoService.findAll().forEach(producto -> System.out.println(producto));

        //productos.forEach(producto -> System.out.println(producto));

        categoria.getProductos().forEach(p -> {
            System.out.println(p.getNombre() + " "+p.getPvp()+ " euros");
        });






    }
}
