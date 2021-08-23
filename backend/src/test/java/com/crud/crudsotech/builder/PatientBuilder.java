package com.crud.crudsotech.builder;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.entities.data.Father;
import com.crud.crudsotech.entities.data.Mother;
import com.crud.crudsotech.entities.data.Parents;
import lombok.Builder;

import java.util.Date;

@Builder
public class PatientBuilder {

    @Builder.Default
    private String name = "Patient Test";
    @Builder.Default
    private Date birthDate = new Date();
    @Builder.Default
    private Parents parents = setParents();

    private static Parents setParents() {
        Father father = new Father();
        father.setName("Father Test");
        father.setBirthDate(new Date());

        Mother mother = new Mother();
        mother.setName("Mother Test");
        mother.setBirthDate(new Date());

        Parents parents = new Parents();
        parents.setMother(mother);
        parents.setFather(father);

        return parents;
    }

    public Patient toPatient() {
        Patient patient = new Patient();
        patient.setId("abc");
        patient.setName(this.name);
        patient.setBirthDate(this.birthDate);
        patient.setParents(this.parents);
        return patient;
    }

}
