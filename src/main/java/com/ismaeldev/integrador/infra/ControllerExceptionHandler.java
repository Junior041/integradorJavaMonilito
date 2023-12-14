package com.ismaeldev.integrador.infra;

import com.ismaeldev.integrador.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
     public ResponseEntity<ExceptionDTO> threadGeneral(Exception exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO(401, exception.getMessage());
        System.out.printf(exception.getMessage());
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
