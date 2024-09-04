<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des patients</title>
</head>
<body>
<div>
    <h1><%= "Bienvenue à l'hôpital Princeton-Plainsboro" %></h1>
</div>
<c:import url="navBar.jsp" />
<c:import url="../../recherchePatient.jsp" />
<c:import url="ajouterPatient.jsp" />
<c:import url="footer.jsp" />
</body>
</html>
