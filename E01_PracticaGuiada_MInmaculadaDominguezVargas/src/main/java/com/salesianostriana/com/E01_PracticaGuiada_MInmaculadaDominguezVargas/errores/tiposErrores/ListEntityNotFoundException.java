package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores;

public class ListEntityNotFoundException extends RuntimeException {

    public ListEntityNotFoundException(Class c){
        super(String.format("No se pueden encontrar elementos del tipo %s", c.getName()));
    }
}
