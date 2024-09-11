package org.example.spring_exo02.controller;

import org.example.spring_exo02.model.Etudiant;
import org.example.spring_exo02.service.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(etudiantService.getAllEtudiants());
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

    @RequestMapping("/formulaire")
    public String formulaire(Model model){
        model.addAttribute("etudiant", new Etudiant());
        return "form";
    }

    @PostMapping("/add")
    public String submitEtudiant(@ModelAttribute("etudiant") Etudiant etudiant) {
        etudiant.setId(UUID.randomUUID());
        etudiantService.addOrModifyEtudiant(etudiant);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("etudiantId") UUID id){
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        etudiantService.deleteEtudiant(etudiant);
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("etudiantId") UUID id, Model model){
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("update", "update");
//        etudiantService.addOrModifyEtudiant(etudiant);
        return "form";
    }

    @PostMapping("/update")
    public String updateEtudiant(@RequestParam("etudiantId") UUID id, @ModelAttribute("etudiant") Etudiant etudiant) {
        etudiant.setId(id);
        etudiantService.addOrModifyEtudiant(etudiant);
        return "redirect:/list";
    }

}
