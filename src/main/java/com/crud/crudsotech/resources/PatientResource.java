package com.crud.crudsotech.resources;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class PatientResource {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient insert(@RequestBody Patient patient) {
        return patientService.insert(patient);
    }

    @GetMapping("{id}")
    public Optional<Patient> findById(@PathVariable("id") String patientId) {
        return patientService.findById(patientId);
    }

}
