package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.anotaciones;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.validadores.FieldsValueMatchValidator;


import javax.lang.model.element.Element;
import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {

    String message() default "Los valores de estos campos no coinciden";

    Class<?>[] groups() default {};

    String field();
    String fieldMatch();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldsValueMatch[] value();
    }
}
