package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model.ApiError;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model.ApiSubError;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model.ApiValidationSubError;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores.EntityNotFoundException;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores.ListEntityNotFoundException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ResponseEntity<Object> buildApiError(HttpStatus status, Exception exception, WebRequest webRequest) {
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, exception.getMessage(), ((ServletWebRequest) webRequest).getRequest().getRequestURI()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

        ApiError apiError = ApiError.builder()
                .estado(HttpStatus.NOT_FOUND)
                .mensaje(exception.getMessage())
                .codigo(HttpStatus.NOT_FOUND.value())
                .fecha(LocalDateTime.now())
                .build();

        return ResponseEntity.ok().body(apiError);
    }

    @ExceptionHandler(ListEntityNotFoundException.class)
    public ResponseEntity<?> handleListEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest) {

        ApiError apiError = ApiError.builder()
                .estado(HttpStatus.NOT_FOUND)
                .mensaje(exception.getMessage())
                .codigo(HttpStatus.NOT_FOUND.value())
                .fecha(LocalDateTime.now())
                .build();

        return ResponseEntity.ok().body(apiError);
    }

    private ResponseEntity<Object> buildApiErrorWithSubError(HttpStatus estado, String mensaje, WebRequest request, List<ApiSubError> subErrores) {
        return ResponseEntity
                .status(estado)
                .body(new ApiError(estado, mensaje, ((ServletWebRequest) request).getRequest().getRequestURI(), subErrores, LocalDateTime.now()));

    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> handleConstrintViolationException(ConstraintViolationException exception, WebRequest request) {
        return buildApiErrorWithSubError(HttpStatus.BAD_REQUEST,
                "Errores varios en la validación",
                request,
                exception.getConstraintViolations()
                        .stream()
                        .map(cv -> ApiValidationSubError.builder()
                                .objeto(cv.getRootBeanClass().getSimpleName())
                                .campo(((PathImpl)cv.getPropertyPath()).getLeafNode().asString())
                                .valorRechazado(cv.getInvalidValue())
                                .mensaje(cv.getMessage())
                                .build())
                        .collect(Collectors.toList())
        );

    }



    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {


        List<ApiSubError> subErroresList = new ArrayList<>();

        exception.getAllErrors().forEach(error -> {

            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;

                subErroresList.add(
                        ApiValidationSubError.builder()
                                .objeto(fieldError.getObjectName())
                                .campo(fieldError.getField())
                                .valorRechazado(fieldError.getRejectedValue())
                                .mensaje(fieldError.getDefaultMessage())
                                .build()
                );
            } else {
                ObjectError objectError = (ObjectError) error;
                subErroresList.add(ApiValidationSubError.builder()
                        .objeto(objectError.getObjectName())
                        .mensaje(objectError.getDefaultMessage())
                        .build()
                );
            }
        });

        return buildApiErrorWithSubError(
                HttpStatus.BAD_REQUEST,
                "Errores varios en la validación",
                request,
                subErroresList.isEmpty() ? null : subErroresList
        );

    }



}
