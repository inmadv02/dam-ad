package com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores;

import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.model.ApiError;
import com.salesianostriana.com.E01_PracticaGuiada_MInmaculadaDominguezVargas.errores.tiposErrores.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private final ResponseEntity<Object> buildApiError(Exception exception, WebRequest webRequest){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ApiError(HttpStatus.NOT_FOUND, exception.getMessage(), ((ServletWebRequest) webRequest).getRequest().getRequestURI()));
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(EntityNotFoundException exception, WebRequest webRequest){
        return buildApiError(exception, webRequest);
    }




}
