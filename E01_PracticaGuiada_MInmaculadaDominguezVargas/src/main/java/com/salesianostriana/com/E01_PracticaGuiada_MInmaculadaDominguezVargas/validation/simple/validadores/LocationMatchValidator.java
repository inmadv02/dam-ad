package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.validadores;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones.LocationMatch;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationMatchValidator implements ConstraintValidator<LocationMatch, String> {



    @Override
    public void initialize(LocationMatch constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        String cadena = "^([-+]?\\d{1,2}[.]\\d+),\\s*([-+]?\\d{1,3}[.]\\d+)$";
        Pattern patron = Pattern.compile(cadena);

        Matcher coincide = patron.matcher(s);

        return coincide.find();


    }
}
