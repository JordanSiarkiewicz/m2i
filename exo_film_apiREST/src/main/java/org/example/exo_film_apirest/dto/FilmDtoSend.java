package org.example.exo_film_apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo_film_apirest.entity.Realisateur;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDtoSend {
    private long id;
    private String nom;
    private String dateDeSortie;
    private String description;
    private String duree;
    private String genre;
    private String realisateur;
}
