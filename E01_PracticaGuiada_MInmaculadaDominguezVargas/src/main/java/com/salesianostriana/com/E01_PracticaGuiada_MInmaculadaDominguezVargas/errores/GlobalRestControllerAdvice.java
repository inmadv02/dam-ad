package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model.ApiError;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model.ApiSubError;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model.ApiValidationSubError;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores.EntityNotFoundException;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores.ListEntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ResponseEntity<Object> buildApiError(HttpStatus status, Exception exception, WebRequest webRequest){
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, exception.getMessage(), ((ServletWebRequest) webRequest).getRequest().getRequestURI()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest){

        ApiError apiError = ApiError.builder()
                .estado(HttpStatus.NOT_FOUND)
                .mensaje(exception.getMessage())
                .codigo(HttpStatus.NOT_FOUND.value())
                .fecha(LocalDateTime.now())
                .build();

        return ResponseEntity.ok().body(apiError);
    }

    @ExceptionHandler(ListEntityNotFoundException.class)
    public ResponseEntity<?> handleListEntityNotFoundException(EntityNotFoundException exception, WebRequest webRequest){

        ApiError apiError = ApiError.builder()
                .estado(HttpStatus.NOT_FOUND)
                .mensaje(exception.getMessage())
                .codigo(HttpStatus.NOT_FOUND.value())
                .fecha(LocalDateTime.now())
                .build();

        return ResponseEntity.ok().body(apiError);
    }

    private ResponseEntity<Object> buildApiError(HttpStatus status, String mensaje, WebRequest request, List<ApiSubError> subErrores) {
        return ResponseEntity
                .status(status)
                .body(new ApiError(status, mensaje, ((ServletWebRequest) request).getRequest().getRequestURI(), subErrores));

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return buildApiError(status, "Errores varios en la validación", request, ex.getFieldErrors()
                .stream().map(error -> ApiValidationSubError.builder()
                        .objeto(error.getObjectName())
                        .campo(error.getField())
                        .valorRechazado(error.getRejectedValue())
                        .mensaje(error.getDefaultMessage())
                        .build())
                .collect(Collectors.toList())
        );
    }
}
