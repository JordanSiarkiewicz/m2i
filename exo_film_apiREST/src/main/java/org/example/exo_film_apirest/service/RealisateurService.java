package org.example.exo_film_apirest.service;

import org.example.exo_film_apirest.dto.RealisateurDtoReceive;
import org.example.exo_film_apirest.entity.Realisateur;
import org.example.exo_film_apirest.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealisateurService {

    @Autowired
    private RealisateurRepository realisateurRepository;

    public Realisateur getById (long id) {
        return realisateurRepository.findById(id).orElse(null);
    }

    public Realisateur create (RealisateurDtoReceive realisateurDtoReceive) {
        Realisateur realisateurCreated = Realisateur.builder()
                .nom(realisateurDtoReceive.getNom())
                .prenom(realisateurDtoReceive.getPrenom())
                .dateDeNaissance(realisateurDtoReceive.getDateDeNaissance())
                .nationalite(realisateurDtoReceive.getNationalite()).build();

                return realisateurRepository.save(realisateurCreated);
    }

    public List<Realisateur> getAll() {
        return (List<Realisateur>) realisateurRepository.findAll();
    }

    public void deleteRealisateur(Long id){
        realisateurRepository.deleteById(id);
    }

    public Realisateur updateRealisateur(Long id, Realisateur updateRealisateur){
        Realisateur realisateurExist = getById(id);
        if(realisateurExist != null){
            realisateurRepository.save(updateRealisateur);
        }
        return realisateurExist;
    }
}
