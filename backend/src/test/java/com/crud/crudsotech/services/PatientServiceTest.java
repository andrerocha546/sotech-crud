package com.crud.crudsotech.services;

import com.crud.crudsotech.builder.PatientBuilder;
import com.crud.crudsotech.entities.Patient;
import com.crud.crudsotech.repositories.PatientRepository;
import com.crud.crudsotech.services.exceptions.PatientNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

    @Mock
    private PatientRepository repository;
    @InjectMocks
    private PatientService service;
    private Patient patient;

    @BeforeEach
    void setUp() {
        this.patient = PatientBuilder.builder().build().toPatient();
    }

    @Test
    public void whenAPatientWereSavedItShouldReturnThePatient() {
        when(repository.save(any())).thenReturn(patient);

        Patient patientCreated = service.insert(patient);

        patientAssertions(patient, patientCreated);
    }

    @Test
    public void whenFindAnUserByIdItShouldReturnTheUser() {
        when(repository.findById(patient.getId())).thenReturn(Optional.of(patient));

        Patient patientCreated = service.findById(patient.getId());

        patientAssertions(patient, patientCreated);
    }

    @Test
    public void whenTryFindAPatientThatDoesntExistsItShouldReturnAnError() {
        PatientNotFoundException exception = assertThrows(PatientNotFoundException.class,
                () -> service.findById("blabj"));

        assertAll(
                () -> assertEquals("Paciente não encontrado!", exception.getMessage())
        );
    }

    private void patientAssertions(Patient patient, Patient patientCreated) {
        assertAll(
                () -> assertEquals(patient.getName(), patientCreated.getName()),
                () -> assertEquals(patient.getBirthDate(), patientCreated.getBirthDate()),
                () -> {
                    assertEquals(patient.getParents().getFather().getName(),
                            patientCreated.getParents().getFather().getName());
                    assertEquals(patient.getParents().getFather().getBirthDate(),
                            patientCreated.getParents().getFather().getBirthDate());
                },
                () -> {
                    assertEquals(patient.getParents().getMother().getName(),
                            patientCreated.getParents().getMother().getName());
                    assertEquals(patient.getParents().getMother().getBirthDate(),
                            patientCreated.getParents().getMother().getBirthDate());
                }
        );
    }

}
