package org.example.exo_film_apirest.controller;

import org.example.exo_film_apirest.dto.FilmDtoReceive;
import org.example.exo_film_apirest.dto.FilmDtoSend;
import org.example.exo_film_apirest.entity.Film;
import org.example.exo_film_apirest.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public ResponseEntity<List<FilmDtoSend>> getFilms() {
        List<Film> films = filmService.getAllFilms();
        List<FilmDtoSend> filmDtoSends = new ArrayList<>();
        for (Film film : films) {
            filmDtoSends.add(new FilmDtoSend(film.getId(),film.getNom(),film.getDateDeSortie(),film.getDescription(),film.getDuree(),film.getGenre(),film.getRealisateur()));
        }
        return ResponseEntity.ok(filmDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<FilmDtoSend> getFilmById(@PathVariable long id) {
        Film film = filmService.getFilmById(id);
        FilmDtoSend filmDtoSend = new FilmDtoSend(film.getId(),film.getNom(),film.getDateDeSortie(),film.getDescription(),film.getDuree(),film.getGenre(),film.getRealisateur());
        return ResponseEntity.ok(filmDtoSend);
    }

    @PostMapping
    public ResponseEntity<FilmDtoSend> addFilm(@RequestBody FilmDtoReceive filmDtoReceive) {
        Film film = filmService.createFilm(filmDtoReceive);
        FilmDtoSend filmDtoSend = new FilmDtoSend(film.getId(),film.getNom(),film.getDateDeSortie(),film.getDescription(),film.getDuree(),film.getGenre(),film.getRealisateur());
        return new ResponseEntity<>(filmDtoSend, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFilm (@PathVariable("id") long id){
        filmService.deleteFilm(id);
        return ResponseEntity.ok("Film Deleted");
    }

    @PutMapping()
    public ResponseEntity<Film> updateFilm (@RequestBody Film film){
        filmService.updateFilm(film.getId(),film);
        return ResponseEntity.ok(film);
    }

//    @GetMapping("/realisateur/{id}")
//    public ResponseEntity<FilmDtoSend> getFilmByRealisateurId(@PathVariable long id) {
//        Film film = filmService.getAllFilmsByRealisateur(id);
//        FilmDtoSend filmDtoSend = new FilmDtoSend(film.getId(),film.getNom(),film.getDateDeSortie(),film.getDescription(),film.getDuree(),film.getGenre(),film.getRealisateur());
//        return ResponseEntity.ok(filmDtoSend);
//
////        List<Film> films = filmService.getAllFilmsByRealisateur(id);
////        List<FilmDtoSend> filmDtoSends = new ArrayList<>();
////        for (Film film : films) {
////            filmDtoSends.add(new FilmDtoSend(film.getId(),film.getNom(),film.getDateDeSortie(),film.getDescription(),film.getDuree(),film.getGenre(),film.getRealisateur()));
////        }
////        return ResponseEntity.ok(filmDtoSends);
//    }
}
