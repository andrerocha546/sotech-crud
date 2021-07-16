package com.crud.crudsotech.services;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient update(Patient patient, String patientId) {
        Optional<Patient> newPatient = findById(patientId);
        updateData(newPatient, patient);
        return repository.save(newPatient.get());
    }

    private void updateData(Optional<Patient> newPatient, Patient patient) {
        newPatient.get().setName(patient.getName());
        newPatient.get().setAge(patient.getAge());
        newPatient.get().setParents(patient.getParents());
    }

    public void deleteById(String patientId) {
        repository.deleteById(patientId);
    }

}
