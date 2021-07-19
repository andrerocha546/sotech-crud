package com.crud.crudsotech.exceptionhandler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

@Getter
@Builder
public class Problem {

    private HttpStatus status;
    private OffsetDateTime timestamp;
    private String error;
    private String message;

}
