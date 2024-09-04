package org.example.exo_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo_hopital.entity.Patient;
import org.example.exo_hopital.repository.PatientRepository;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/ajouterpatient")
public class AjouterServlet extends HttpServlet {

    private PatientRepository patientRepository;
    private String titre;

    @Override
    public void init(){
        titre = "Ajouter un patient";
        patientRepository = new PatientRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("titre", titre);
        Patient newPatient = new Patient();
        newPatient.setIdPatient(0);
        req.setAttribute("patient", newPatient);
        getServletContext().getRequestDispatcher("/WEB-INF/component/ajouterPatient.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringId = req.getParameter("id");
        int id = Integer.parseInt((stringId));
        Patient patient;

        if (id != 0) {
            patient = patientRepository.findById(id);
        } else {
            patient = new Patient();
        }

        patient.setNomPatient(req.getParameter("nom"));
        patient.setPrenomPatient(req.getParameter("prenom"));
        patient.setDateNaissance(LocalDate.parse(req.getParameter("dateDeNaissance")));

        patientRepository.createOrUpdate(patient);
        req.setAttribute("patient", patient); // Set updated patient in request
        doGet(req, resp);
    }
}
