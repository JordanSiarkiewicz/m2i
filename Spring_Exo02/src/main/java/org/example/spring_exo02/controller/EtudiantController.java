package org.example.spring_exo02.controller;

import org.example.spring_exo02.model.Etudiant;
import org.example.spring_exo02.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class EtudiantController {
    private EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @RequestMapping("/")
    public String homePage(){ return "pagea"; }

    @RequestMapping("/detail/{etudiantId}")
    public String detailPage(@PathVariable("etudiantId") UUID id, Model model){
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        return "pagec";
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("etudiants", etudiantService.getAllEtudiants());
        return "pageb";
    }

    @RequestMapping("/search")
    public String searchEtudiant(@RequestParam("name") String name, Model model){
        Etudiant etudiant = etudiantService.getEtudiantByName(name);
        model.addAttribute("etudiant", etudiant);
        return "pagec";
    }

    @RequestMapping("/subscribe")
    public String subscribe(){return  "subscribe";}

}
