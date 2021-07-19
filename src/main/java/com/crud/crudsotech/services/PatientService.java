package com.crud.crudsotech.services;

import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.repositories.PatientRepository;
import com.crud.crudsotech.services.exceptions.PatientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient insert(Patient patient) {
        return repository.save(patient);
    }

    public Patient findById(String patientId) {
        return repository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Paciente não encontrado!"));
    }

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient update(Patient patient, String patientId) {
        Patient newPatient = findById(patientId);
        updateData(newPatient, patient);
        return repository.save(newPatient);
    }

    private void updateData(Patient newPatient, Patient patient) {
        newPatient.setName(patient.getName());
        newPatient.setBirthDate(patient.getBirthDate());
        newPatient.setParents(patient.getParents());
    }

    public void deleteById(String patientId) {
        repository.deleteById(patientId);
    }

}
