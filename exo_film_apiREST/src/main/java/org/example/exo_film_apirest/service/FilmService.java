package org.example.exo_film_apirest.service;

import org.example.exo_film_apirest.dto.FilmDtoReceive;
import org.example.exo_film_apirest.entity.Film;
import org.example.exo_film_apirest.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public Film getFilmById(long id) {
        return filmRepository.findById(id).orElseThrow();
    }

    public Film createFilm(FilmDtoReceive filmDtoReceive) {
        Film filmCreated = Film.builder()
                .nom(filmDtoReceive.getNom())
                .dateDeSortie(filmDtoReceive.getDateDeSortie())
                .description(filmDtoReceive.getDescription())
                .duree(filmDtoReceive.getDuree())
                .genre(filmDtoReceive.getGenre())
                .realisateur(filmDtoReceive.getRealisateur()).build();

        return filmRepository.save(filmCreated);
    }

    public List<Film> getAllFilms() {
        return (List<Film>) filmRepository.findAll();
    }

//    public List<Film> getAllFilmsByRealisateur(int realisateurId) {
//        return (List<Film>) filmRepository.findByRealisateur(realisateurId);
//    }

    public void deleteFilm(Long id){
        filmRepository.deleteById(id);
    }

    public Film updateFilm(Long id, Film updateFilm){
        Film filmExist = getFilmById(id);
        if(filmExist != null){
            filmRepository.save(updateFilm);
        }
        return filmExist;
    }
}
