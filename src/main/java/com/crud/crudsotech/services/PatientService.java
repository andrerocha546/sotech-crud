package com.crud.crudsotech.services;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient insert(Patient patient) {
        return repository.save(patient);
    }

    public Optional<Patient> findById(String patientId) {
        return repository.findById(patientId);
    }
}
