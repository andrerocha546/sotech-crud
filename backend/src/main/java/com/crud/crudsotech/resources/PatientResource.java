package com.crud.crudsotech.resources;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientResource {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient insert(@RequestBody Patient patient) {
        return patientService.insert(patient);
    }

    @GetMapping("{id}")
    public Patient findById(@PathVariable("id") String patientId) {
        return patientService.findById(patientId);
    }

    @GetMapping
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @PutMapping("{id}")
    public Patient update(@RequestBody Patient patient, @PathVariable("id") String patientId) {
        return patientService.update(patient, patientId);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") String patientId) {
        patientService.deleteById(patientId);
    }

}
