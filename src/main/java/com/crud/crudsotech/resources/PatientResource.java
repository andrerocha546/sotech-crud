package com.crud.crudsotech.resources;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class PatientResource {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient insert(@RequestBody Patient patient) {
        return patientService.insert(patient);
    }

}
