package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.validadores;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones.LocationMatch;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationMatchValidator implements ConstraintValidator<LocationMatch, String> {

    private String ubicacion;

    @Override
    public void initialize(LocationMatch constraintAnnotation) {
        ubicacion = constraintAnnotation.ubicacion();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String cadena = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$";
        Pattern patron = Pattern.compile(cadena);

        Matcher coincide = patron.matcher(this.ubicacion);

        if(coincide.find()){
            return true;
        }

        else {
            return false;
        }

    }
}
