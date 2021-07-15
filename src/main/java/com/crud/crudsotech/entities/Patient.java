package com.crud.crudsotech.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "patient")
public class Patient {

    @Id
    private String id;
    private String name;
    private Integer age;

}
