package org.example.exo_film_apirest.repository;

import org.example.exo_film_apirest.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {

//    public default List<Film> findByRealisateur(long id){
//        return findByRealisateur(id);
//    }
}
