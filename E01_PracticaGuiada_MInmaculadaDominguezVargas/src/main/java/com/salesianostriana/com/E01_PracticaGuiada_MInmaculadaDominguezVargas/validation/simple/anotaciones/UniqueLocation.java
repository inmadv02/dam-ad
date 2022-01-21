package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.anotaciones;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.validadores.LocationMatchValidator;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.simple.validadores.UniqueLocationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UniqueLocationValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueLocation {

    String message() default "Ya hay una estación de servicio en esa localización";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};



}
