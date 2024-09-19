package org.example.exo_film_apirest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="table_film")
public class Film {
    @Id
    @GeneratedValue
    private long id;

    private String nom;
    private String dateDeSortie;
    private String description;
    private String duree;
    private String genre;

//    @ManyToOne()
//    @JoinColumn(name = "id_realisateur")
    private String realisateur;
}
