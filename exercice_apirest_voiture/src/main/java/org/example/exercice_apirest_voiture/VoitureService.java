package org.example.exercice_apirest_voiture;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class VoitureService {
    public List<Voiture> voitures;

    public Voiture save(int id, String marque, String anneeFabrication, String couleur){
        return new Voiture(id,marque,anneeFabrication,couleur);
    }
}
