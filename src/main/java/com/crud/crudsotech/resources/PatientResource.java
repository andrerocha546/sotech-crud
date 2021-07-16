package com.crud.crudsotech.resources;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class PatientResource {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity.BodyBuilder insert(@RequestBody Patient patient) {
        patientService.insert(patient);
        return ResponseEntity.status(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> findById(@PathVariable("id") String patientId) {
        Optional<Patient> patient = patientService.findById(patientId);
        return ResponseEntity.ok().body(patient.get());
    }

    @GetMapping
    public ResponseEntity<List<Patient>> findAll() {
        List<Patient> all = patientService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @PutMapping("{id}")
    public ResponseEntity<Patient> update(@RequestBody Patient patient, @PathVariable("id") String patientId) {
        Patient pat = patientService.update(patient, patientId);
        return ResponseEntity.ok().body(pat);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") String patientId) {
        patientService.deleteById(patientId);
        return ResponseEntity.noContent().build();
    }

}
