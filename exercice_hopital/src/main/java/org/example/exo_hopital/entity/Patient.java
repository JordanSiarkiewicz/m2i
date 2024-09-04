package org.example.exo_hopital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private int idPatient;
    @Column(name = "nom_patient")
    private String nomPatient;
    @Column(name = "prenom_patient")
    private String prenomPatient;
    @Column(name = "date_naissance")
    private LocalDate dateNaissance;
}
