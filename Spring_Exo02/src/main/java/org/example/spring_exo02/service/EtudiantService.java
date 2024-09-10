package org.example.spring_exo02.service;

import org.example.spring_exo02.model.Etudiant;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EtudiantService {
    private final Map<UUID, Etudiant> etudiants;

    public EtudiantService() {
        etudiants = new HashMap<>();

        Etudiant etudiantA = Etudiant.builder()
                .id(UUID.randomUUID())
                .name("Rambo")
                .surname("John")
                .age(35)
                .email("john-rambo@vietnam.com")
                .build();

        Etudiant etudiantB = Etudiant.builder()
                .id(UUID.randomUUID())
                .name("Connor")
                .surname("John")
                .age(18)
                .email("john-connor@skynet.com")
                .build();

        Etudiant etudiantC = Etudiant.builder()
                .id(UUID.randomUUID())
                .name("Mclane")
                .surname("John")
                .age(30)
                .email("john-mclane@nakatomi.com")
                .build();

        etudiants.put(etudiantA.getId(), etudiantA);
        etudiants.put(etudiantB.getId(), etudiantB);
        etudiants.put(etudiantC.getId(), etudiantC);
    }

    public List<Etudiant> getAllEtudiants(){
        return etudiants.values().stream().toList();
    }

    public Etudiant getEtudiantById(UUID id){
        return etudiants.get(id);
    }

    public Etudiant getEtudiantByName(String name){
        return etudiants.values().stream().filter(etudiant -> etudiant.getName().equals(name)).findFirst().orElse(null);
    }

    public void addEtudiant(Etudiant etudiant){
//        Etudiant etudiantC = Etudiant.builder().id(UUID.randomUUID()).name(etudiant.getName()).surname(etudiant.getSurname()).age(etudiant.getAge()).email(etudiant.getEmail()).build();
        if (etudiant.getId() == null){
            etudiant.setId(UUID.randomUUID());
        }
        etudiants.put(etudiant.getId(), etudiant);
    }
}
