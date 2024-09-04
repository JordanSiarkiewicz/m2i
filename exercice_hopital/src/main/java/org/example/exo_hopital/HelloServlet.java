package org.example.exo_hopital;

import java.io.*;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.exo_hopital.entity.Patient;
import org.example.exo_hopital.repository.PatientRepository;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private PatientRepository patientRepository ;
    private List<Patient> patientsList;
    private String titre;

    public void init() {
        patientRepository = new PatientRepository();
        patientsList = patientRepository.findAll();
        this.titre = "Affichage de la liste des patients";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
    }

    public void destroy() {
    }
}