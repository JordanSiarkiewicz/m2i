<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="patient" class="org.example.exo_hopital.entity.Patient" scope="request"/>
<div>
    <h2>Ajouter patient</h2>
    <form action="ajouterPatient" method="post">
        <label for="nom">Rechercher un patient</label>
        <input type="text" id="nom" name="nom" required <%=patient.getNomPatient() != null ? "value='"+patient.getNomPatient()+"'":"" %>  >
        <button>Valider</button>

    </form>
</div>


