package com.crud.crudsotech.services.exceptions;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String msg) {
        super(msg);
    }

}
