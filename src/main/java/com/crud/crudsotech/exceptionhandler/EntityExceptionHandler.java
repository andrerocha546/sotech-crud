package com.crud.crudsotech.exceptionhandler;

import com.crud.crudsotech.entities.exceptions.InvalidBirthDateException;
import com.crud.crudsotech.entities.exceptions.InvalidNameException;
import com.crud.crudsotech.services.exceptions.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(InvalidNameException.class)
    public ResponseEntity<Object> handlerInvalidNameException(InvalidNameException nameException) {
        HttpStatus notAcceptable = HttpStatus.NOT_ACCEPTABLE;
        Problem problem = createProblem(nameException, notAcceptable);
        return ResponseEntity.status(notAcceptable).body(problem);
    }

    @ExceptionHandler(InvalidBirthDateException.class)
    public ResponseEntity<Object> handlerInvalidBirthDateException(InvalidBirthDateException birthDateException) {
        HttpStatus notAcceptable = HttpStatus.NOT_ACCEPTABLE;
        Problem problem = createProblem(birthDateException, notAcceptable);
        return ResponseEntity.status(notAcceptable).body(problem);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Object> handlerPatientNotFoundException(PatientNotFoundException notFoundException) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        Problem problem = createProblem(notFoundException, notFound);
        return ResponseEntity.status(notFound).body(problem);
    }

    private Problem createProblem(Exception ex, HttpStatus status) {
        var problem = Problem
                .builder()
                .timestamp(OffsetDateTime.now())
                .error(ex.getMessage())
                .message(ex.getMessage())
                .status(status)
                .build();
        return problem;
    }

}
