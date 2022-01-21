package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.anotaciones;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.validadores.FechaABeforeFechaRValidator;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.validadores.FieldsValueMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FechaABeforeFechaRValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaABeforeFechaR {

    String message() default "La fecha de apertura debe ser menor o igual a la fecha de registro";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fechaR();
    String fechaA();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FechaABeforeFechaR[] value();
    }

}
