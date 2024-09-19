package org.example.exo_film_apirest.controller;

import org.example.exo_film_apirest.dto.RealisateurDtoReceive;
import org.example.exo_film_apirest.dto.RealisateurDtoSend;
import org.example.exo_film_apirest.entity.Realisateur;
import org.example.exo_film_apirest.service.RealisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/realisateur")
public class RealisateurController {

    private RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public ResponseEntity<List<RealisateurDtoSend>> getRealisateur() {
        List<Realisateur> realisateurs = realisateurService.getAll();
        List<RealisateurDtoSend> realisateurDtoSends = new ArrayList<>();
        for (Realisateur realisateur : realisateurs) {
            realisateurDtoSends.add(new RealisateurDtoSend(realisateur.getId(),realisateur.getNom(),realisateur.getPrenom(),realisateur.getDateDeNaissance(),realisateur.getNationalite()));
        }
        return ResponseEntity.ok(realisateurDtoSends);
    }

    @GetMapping("{id}")
    public ResponseEntity<RealisateurDtoSend> getRealisateurById(@PathVariable long id) {
        Realisateur realisateur = realisateurService.getById(id);
        RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(realisateur.getId(),realisateur.getNom(),realisateur.getPrenom(),realisateur.getDateDeNaissance(),realisateur.getNationalite());
        return ResponseEntity.ok(realisateurDtoSend);
    }

    @PostMapping
    public ResponseEntity<RealisateurDtoSend> addRealisateur(@RequestBody RealisateurDtoReceive realisateurDtoReceive) {
        Realisateur realisateur = realisateurService.create(realisateurDtoReceive);
        RealisateurDtoSend realisateurDtoSend = new RealisateurDtoSend(realisateur.getId(),realisateur.getNom(),realisateur.getPrenom(),realisateur.getDateDeNaissance(),realisateur.getNationalite());
        return new ResponseEntity<>(realisateurDtoSend, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRealisateur (@PathVariable("id") long id){
        realisateurService.deleteRealisateur(id);
        return ResponseEntity.ok("Realisateur supprimé");
    }

    @PutMapping()
    public ResponseEntity<Realisateur> updateRealisateur (@RequestBody Realisateur realisateur){
        realisateurService.updateRealisateur(realisateur.getId(),realisateur);
        return ResponseEntity.ok(realisateur);
    }
}
