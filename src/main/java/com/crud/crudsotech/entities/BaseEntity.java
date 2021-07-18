package com.crud.crudsotech.entities;

import com.crud.crudsotech.entities.exceptions.InvalidNameException;

import java.util.Date;

public class BaseEntity {

    private String name;
    private Date birthDate;

    public BaseEntity() {
    }

    public BaseEntity(String name, Date birthDate) {
        setIfNameIsValid(name);
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        setIfNameIsValid(name);
    }

    private void setIfNameIsValid(String name) {
        String expression = "^[a-zA-Z\\s]+";
        if (!name.matches(expression) || name.length() < 5) {
            throw new InvalidNameException("Digite um nome valido!");
        }
        this.name = name;
    }

}
