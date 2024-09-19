package org.example.exo_film_apirest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="table_realisateur")
public class Realisateur {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String nationalite;

//    @OneToMany(mappedBy = "realisateur")
//    private List<Film> films;
}
