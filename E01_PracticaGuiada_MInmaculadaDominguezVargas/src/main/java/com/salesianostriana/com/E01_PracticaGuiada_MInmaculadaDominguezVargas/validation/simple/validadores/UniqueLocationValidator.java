package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.validadores;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.repositories.EstacionRepository;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones.LocationMatch;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones.UniqueLocation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueLocationValidator implements ConstraintValidator<UniqueLocation, String> {

    @Autowired
    protected EstacionRepository repositorio;

    @Override
    public void initialize(UniqueLocation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !repositorio.existsByUbicacion(s);
    }

}
