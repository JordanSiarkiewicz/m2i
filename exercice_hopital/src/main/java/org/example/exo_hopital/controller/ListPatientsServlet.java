package org.example.exo_hopital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exo_hopital.entity.Patient;
import org.example.exo_hopital.repository.PatientRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/listpatients")
public class ListPatientsServlet extends HttpServlet {

    private PatientRepository patientRepository ;
    private List<Patient> patientsList;
    private String titre;

    @Override
    public void init() throws ServletException {
        patientRepository = new PatientRepository();
        patientsList = patientRepository.findAll();
        this.titre = "Affichage de la liste des patients";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        patientsList = patientRepository.findAll();
        req.setAttribute("titre", titre);
        req.setAttribute("patients", patientsList);
        getServletContext().getRequestDispatcher("/WEB-INF/component/listPatients.jsp").forward(req, resp);
    }
}
