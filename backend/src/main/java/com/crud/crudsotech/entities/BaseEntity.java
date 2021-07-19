package com.crud.crudsotech.entities;

import com.crud.crudsotech.entities.exceptions.InvalidBirthDateException;
import com.crud.crudsotech.entities.exceptions.InvalidNameException;

import java.util.Date;

public class BaseEntity {

    private String name;
    private Date birthDate;

    public BaseEntity() {
    }

    public BaseEntity(String name, Date birthDate) {
        setIfNameIsValid(name);
        setIfBirthDateIsValid(birthDate);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        setIfBirthDateIsValid(birthDate);
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

    private void setIfBirthDateIsValid(Date birthDate) {
        long diff = new Date().getTime() - birthDate.getTime();
        long differenceInYears = (diff / (1000l * 60 * 60 * 24 * 365));

        if (differenceInYears >= 130 || differenceInYears < 0) {
            throw new InvalidBirthDateException("O paciente deve ter entre 0 e 130 anos!");
        }
        this.birthDate = birthDate;
    }

}
