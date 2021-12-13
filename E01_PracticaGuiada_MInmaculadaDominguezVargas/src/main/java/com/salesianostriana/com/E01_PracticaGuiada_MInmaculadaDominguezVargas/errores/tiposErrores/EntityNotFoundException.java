package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id, Class c){
        super(String.format("No se puede encontrar una entidad del tipo %s con ID: %s", c.getName(), id));
    }

}
