<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/styles.css">
    <title>hôpital Princeton-Plainsboro</title>
</head>
<body>
<div>
    <h1><%= "Bienvenue à l'hôpital Princeton-Plainsboro" %></h1>
</div>
<c:import url="WEB-INF/component/navBar.jsp" />

<br/>
<h2>A propos de nous</h2>
<p>Nous sommes clairement les meilleurs alors faites-nous confiance, tout simplement ;)</p>
<c:import url="WEB-INF/component/footer.jsp" />
</body>
</html>