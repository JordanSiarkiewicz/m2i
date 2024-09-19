package org.example.exo_film_apirest.repository;

import org.example.exo_film_apirest.entity.Realisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends CrudRepository<Realisateur, Long> {
}
