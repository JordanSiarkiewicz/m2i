package org.example.exo_film_apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo_film_apirest.entity.Film;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RealisateurDtoReceive {
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String nationalite;
//    private List<Film> films;
}
