package com.crud.crudsotech.repositories;

import com.crud.crudsotech.entities.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Integer> {
}
