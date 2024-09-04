package org.example.exo_hopital.repository;

import org.example.exo_hopital.entity.Patient;

public class PatientRepository extends BaseRepository<Patient>{
    public PatientRepository() {
        super(Patient.class);
    }
}
