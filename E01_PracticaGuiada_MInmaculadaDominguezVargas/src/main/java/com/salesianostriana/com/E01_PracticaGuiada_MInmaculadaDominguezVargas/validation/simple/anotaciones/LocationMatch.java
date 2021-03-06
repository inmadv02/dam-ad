package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.validadores.LocationMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = LocationMatchValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocationMatch {

    String message() default "El formato de la ubicación no es correcto";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};



}
