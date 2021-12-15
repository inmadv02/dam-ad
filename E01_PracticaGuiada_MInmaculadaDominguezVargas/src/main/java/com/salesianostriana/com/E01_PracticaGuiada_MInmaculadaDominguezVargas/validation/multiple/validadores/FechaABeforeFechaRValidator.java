package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.validadores;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.validation.multiple.anotaciones.FechaABeforeFechaR;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FechaABeforeFechaRValidator implements ConstraintValidator<FechaABeforeFechaR, Object> {

    String fechaApertura;
    String fechaRegistro;

    @Override
    public void initialize(FechaABeforeFechaR constraintAnnotation) {
        this.fechaApertura = constraintAnnotation.fechaA();
        this.fechaRegistro = constraintAnnotation.fechaR();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        LocalDateTime fechaA = (LocalDateTime) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fechaApertura);
        LocalDateTime fechaR = (LocalDateTime) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fechaRegistro);

        return fechaA.isBefore(fechaR) || fechaA.isEqual(fechaR);
    }
}
