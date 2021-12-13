package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }

}
